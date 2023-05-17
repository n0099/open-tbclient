package com.xiaomi.push;

import com.squareup.wire.WireInput;
import java.io.IOException;
/* loaded from: classes10.dex */
public class d extends IOException {
    public d(String str) {
        super(str);
    }

    public static d a() {
        return new d("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    public static d b() {
        return new d("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static d c() {
        return new d("CodedInputStream encountered a malformed varint.");
    }

    public static d d() {
        return new d(WireInput.PROTOCOL_MESSAGE_CONTAINED_AN_INVALID_TAG_ZERO);
    }

    public static d e() {
        return new d(WireInput.PROTOCOL_MESSAGE_END_GROUP_TAG_DID_NOT_MATCH_EXPECTED_TAG);
    }

    public static d f() {
        return new d("Protocol message tag had invalid wire type.");
    }

    public static d g() {
        return new d("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public static d h() {
        return new d("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }
}
