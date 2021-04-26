package com.tencent.mm.sdk.modelmsg;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import java.io.ByteArrayOutputStream;
/* loaded from: classes6.dex */
public final class WXMediaMessage {
    public static final String ACTION_WXAPPMESSAGE = "com.tencent.mm.sdk.openapi.Intent.ACTION_WXAPPMESSAGE";
    public static final int DESCRIPTION_LENGTH_LIMIT = 1024;
    public static final int MEDIA_TAG_NAME_LENGTH_LIMIT = 64;
    public static final int MESSAGE_ACTION_LENGTH_LIMIT = 2048;
    public static final int MESSAGE_EXT_LENGTH_LIMIT = 2048;
    public static final String TAG = "MicroMsg.SDK.WXMediaMessage";
    public static final int THUMB_LENGTH_LIMIT = 32768;
    public static final int TITLE_LENGTH_LIMIT = 512;
    public String description;
    public IMediaObject mediaObject;
    public String mediaTagName;
    public String messageAction;
    public String messageExt;
    public int sdkVer;
    public byte[] thumbData;
    public String title;

    /* loaded from: classes6.dex */
    public static class Builder {
        public static final String KEY_IDENTIFIER = "_wxobject_identifier_";

        public static WXMediaMessage fromBundle(Bundle bundle) {
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.sdkVer = bundle.getInt("_wxobject_sdkVer");
            wXMediaMessage.title = bundle.getString("_wxobject_title");
            wXMediaMessage.description = bundle.getString("_wxobject_description");
            wXMediaMessage.thumbData = bundle.getByteArray("_wxobject_thumbdata");
            wXMediaMessage.mediaTagName = bundle.getString("_wxobject_mediatagname");
            wXMediaMessage.messageAction = bundle.getString("_wxobject_message_action");
            wXMediaMessage.messageExt = bundle.getString("_wxobject_message_ext");
            String pathOldToNew = pathOldToNew(bundle.getString("_wxobject_identifier_"));
            if (pathOldToNew != null && pathOldToNew.length() > 0) {
                try {
                    IMediaObject iMediaObject = (IMediaObject) Class.forName(pathOldToNew).newInstance();
                    wXMediaMessage.mediaObject = iMediaObject;
                    iMediaObject.unserialize(bundle);
                    return wXMediaMessage;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    a.a("MicroMsg.SDK.WXMediaMessage", "get media object from bundle failed: unknown ident " + pathOldToNew + ", ex = " + e2.getMessage());
                }
            }
            return wXMediaMessage;
        }

        public static String pathNewToOld(String str) {
            if (str == null || str.length() == 0) {
                a.a("MicroMsg.SDK.WXMediaMessage", "pathNewToOld fail, newPath is null");
                return str;
            }
            return str.replace("com.tencent.mm.sdk.modelmsg", "com.tencent.mm.sdk.openapi");
        }

        public static String pathOldToNew(String str) {
            if (str == null || str.length() == 0) {
                a.a("MicroMsg.SDK.WXMediaMessage", "pathOldToNew fail, oldPath is null");
                return str;
            }
            return str.replace("com.tencent.mm.sdk.openapi", "com.tencent.mm.sdk.modelmsg");
        }

        public static Bundle toBundle(WXMediaMessage wXMediaMessage) {
            Bundle bundle = new Bundle();
            bundle.putInt("_wxobject_sdkVer", wXMediaMessage.sdkVer);
            bundle.putString("_wxobject_title", wXMediaMessage.title);
            bundle.putString("_wxobject_description", wXMediaMessage.description);
            bundle.putByteArray("_wxobject_thumbdata", wXMediaMessage.thumbData);
            IMediaObject iMediaObject = wXMediaMessage.mediaObject;
            if (iMediaObject != null) {
                bundle.putString("_wxobject_identifier_", pathNewToOld(iMediaObject.getClass().getName()));
                wXMediaMessage.mediaObject.serialize(bundle);
            }
            bundle.putString("_wxobject_mediatagname", wXMediaMessage.mediaTagName);
            bundle.putString("_wxobject_message_action", wXMediaMessage.messageAction);
            bundle.putString("_wxobject_message_ext", wXMediaMessage.messageExt);
            return bundle;
        }
    }

    /* loaded from: classes6.dex */
    public interface IMediaObject {
        public static final int TYPE_APPDATA = 7;
        public static final int TYPE_EMOJI = 8;
        public static final int TYPE_FILE = 6;
        public static final int TYPE_IMAGE = 2;
        public static final int TYPE_MUSIC = 3;
        public static final int TYPE_PRODUCT = 10;
        public static final int TYPE_TEXT = 1;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_URL = 5;
        public static final int TYPE_VIDEO = 4;

        boolean checkArgs();

        void serialize(Bundle bundle);

        int type();

        void unserialize(Bundle bundle);
    }

    public WXMediaMessage() {
        this(null);
    }

    public WXMediaMessage(IMediaObject iMediaObject) {
        this.mediaObject = iMediaObject;
    }

    public final boolean checkArgs() {
        String str;
        byte[] bArr;
        if (getType() == 8 && ((bArr = this.thumbData) == null || bArr.length == 0)) {
            str = "checkArgs fail, thumbData should not be null when send emoji";
        } else {
            byte[] bArr2 = this.thumbData;
            if (bArr2 == null || bArr2.length <= 32768) {
                String str2 = this.title;
                if (str2 == null || str2.length() <= 512) {
                    String str3 = this.description;
                    if (str3 != null && str3.length() > 1024) {
                        str = "checkArgs fail, description is invalid";
                    } else if (this.mediaObject == null) {
                        str = "checkArgs fail, mediaObject is null";
                    } else {
                        String str4 = this.mediaTagName;
                        if (str4 == null || str4.length() <= 64) {
                            String str5 = this.messageAction;
                            if (str5 == null || str5.length() <= 2048) {
                                String str6 = this.messageExt;
                                if (str6 == null || str6.length() <= 2048) {
                                    return this.mediaObject.checkArgs();
                                }
                                str = "checkArgs fail, messageExt is too long";
                            } else {
                                str = "checkArgs fail, messageAction is too long";
                            }
                        } else {
                            str = "checkArgs fail, mediaTagName is too long";
                        }
                    }
                } else {
                    str = "checkArgs fail, title is invalid";
                }
            } else {
                str = "checkArgs fail, thumbData is invalid";
            }
        }
        a.a("MicroMsg.SDK.WXMediaMessage", str);
        return false;
    }

    public final int getType() {
        IMediaObject iMediaObject = this.mediaObject;
        if (iMediaObject == null) {
            return 0;
        }
        return iMediaObject.type();
    }

    public final void setThumbImage(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.thumbData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
            a.a("MicroMsg.SDK.WXMediaMessage", "put thumb failed");
        }
    }
}
