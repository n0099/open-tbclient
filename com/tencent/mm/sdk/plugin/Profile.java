package com.tencent.mm.sdk.plugin;

import android.net.Uri;
import com.tencent.mm.sdk.contact.RContact;
import com.tencent.mm.sdk.storage.MAutoDBItem;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class Profile extends MAutoDBItem {
    public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/profile");
    public static String[] columns = {"username", "bindqq", "bindmobile", "bindemail", RContact.COL_ALIAS, RContact.COL_NICKNAME, "signature", "province", "city", "weibo", "avatar"};
    private static final Field[] p = MAutoDBItem.getValidFields(Profile.class);
    public String field_alias;
    public String field_avatar;
    public String field_bindemail;
    public String field_bindmobile;
    public long field_bindqq;
    public String field_city;
    public String field_nickname;
    public String field_province;
    public String field_signature;
    public String field_username;
    public String field_weibo;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mm.sdk.storage.MAutoDBItem
    public Field[] fields() {
        return p;
    }
}
