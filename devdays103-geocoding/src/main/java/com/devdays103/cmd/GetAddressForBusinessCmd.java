package com.devdays103.cmd;

import com.devdays103.api.AddressbookService;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;

@Command(scope = "devdays103", name = "get-address-for-business")
@Service
public final class GetAddressForBusinessCmd implements Action {
	@Reference
	AddressbookService addressbookService;

	@Argument(index = 0, name = "businessName", required = true, multiValued = false)
	private String businessName;

	@Override
	public Object execute() throws Exception {
		return addressbookService.getAddress(businessName);
	}
}
