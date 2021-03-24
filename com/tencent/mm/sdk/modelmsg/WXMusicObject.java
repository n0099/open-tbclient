package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
/* loaded from: classes7.dex */
public class WXMusicObject implements WXMediaMessage.IMediaObject {
    public static final int LENGTH_LIMIT = 10240;
    public static final String TAG = "MicroMsg.SDK.WXMusicObject";
    public String musicDataUrl;
    public String musicLowBandDataUrl;
    public String musicLowBandUrl;
    public String musicUrl;

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str;
        String str2;
        String str3 = this.musicUrl;
        if ((str3 == null || str3.length() == 0) && ((str = this.musicLowBandUrl) == null || str.length() == 0)) {
            str2 = "both arguments are null";
        } else {
            String str4 = this.musicUrl;
            if (str4 == null || str4.length() <= 10240) {
                String str5 = this.musicLowBandUrl;
                if (str5 == null || str5.length() <= 10240) {
                    return true;
                }
                str2 = "checkArgs fail, musicLowBandUrl is too long";
            } else {
                str2 = "checkArgs fail, musicUrl is too long";
            }
        }
        a.a("MicroMsg.SDK.WXMusicObject", str2);
        return false;
    }

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxmusicobject_musicUrl", this.musicUrl);
        bundle.putString("_wxmusicobject_musicLowBandUrl", this.musicLowBandUrl);
        bundle.putString("_wxmusicobject_musicDataUrl", this.musicDataUrl);
        bundle.putString("_wxmusicobject_musicLowBandDataUrl", this.musicLowBandDataUrl);
    }

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 3;
    }

    @Override // com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.musicUrl = bundle.getString("_wxmusicobject_musicUrl");
        this.musicLowBandUrl = bundle.getString("_wxmusicobject_musicLowBandUrl");
        this.musicDataUrl = bundle.getString("_wxmusicobject_musicDataUrl");
        this.musicLowBandDataUrl = bundle.getString("_wxmusicobject_musicLowBandDataUrl");
    }
}
