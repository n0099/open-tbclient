package com.vivo.push.sdk.service;
/* loaded from: classes6.dex */
public class CommandClientService extends CommandService {
    @Override // com.vivo.push.sdk.service.CommandService
    public final boolean a(String str) {
        return "com.vivo.pushclient.action.RECEIVE".equals(str);
    }
}
