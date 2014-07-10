package com.squareup.wire;

import com.squareup.protoparser.MessageType;
/* loaded from: classes.dex */
final class ExtensionInfo {
    public final String fqLocation;
    public final String fqType;
    public final MessageType.Label label;
    public final String location;
    public final String type;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExtensionInfo(String str, String str2, String str3, String str4, MessageType.Label label) {
        this.type = str;
        this.fqType = str2;
        this.location = str3;
        this.fqLocation = str4;
        this.label = label;
    }
}
