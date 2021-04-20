package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
/* loaded from: classes6.dex */
public class WXTextObject implements WXMediaMessage.IMediaObject {
    public static final int LENGTH_LIMIT = 10240;
    public static final String TAG = "MicroMsg.SDK.WXTextObject";
    public String text;

    public WXTextObject() {
        this(null);
    }

    public WXTextObject(String str) {
        this.text = str;
    }

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str = this.text;
        if (str == null || str.length() == 0 || this.text.length() > 10240) {
            a.a("MicroMsg.SDK.WXTextObject", "checkArgs fail, text is invalid");
            return false;
        }
        return true;
    }

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxtextobject_text", this.text);
    }

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 1;
    }

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.text = bundle.getString("_wxtextobject_text");
    }
}
