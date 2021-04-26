package d.a.j0.e1.t;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import d.a.c.e.d.l;
import d.a.i0.z0.f0;
import d.a.i0.z0.h0;
import d.a.i0.z0.n;
/* loaded from: classes4.dex */
public class d extends d.a.j0.e1.t.a {

    /* renamed from: b  reason: collision with root package name */
    public static d f53858b = new d();

    /* loaded from: classes4.dex */
    public class a extends f0<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialSettingItemData f53859a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f53860b;

        public a(OfficialSettingItemData officialSettingItemData, String str) {
            this.f53859a = officialSettingItemData;
            this.f53860b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            d.this.b().g(this.f53860b, OrmObject.jsonStrWithObject(this.f53859a));
            return null;
        }
    }

    public static d j() {
        return f53858b;
    }

    @Override // d.a.j0.e1.t.a
    public l<String> b() {
        return d.a.i0.r.r.a.f().g("tb.im_official_chat_setting");
    }

    @Override // d.a.j0.e1.t.a
    public void h(ChatSetting chatSetting) {
        if (chatSetting == null || !(chatSetting instanceof OfficialSettingItemData)) {
            return;
        }
        OfficialSettingItemData officialSettingItemData = (OfficialSettingItemData) chatSetting;
        String myUid = officialSettingItemData.getMyUid();
        String toUid = officialSettingItemData.getToUid();
        if (!TextUtils.isEmpty(myUid) && !TextUtils.isEmpty(toUid)) {
            l<String> b2 = b();
            String str = myUid + "@" + toUid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(officialSettingItemData);
            synchronized (this.f53842a) {
                this.f53842a.put(str, officialSettingItemData);
            }
            b2.g(str, jsonStrWithObject);
        } else if (TbConfig.getDebugSwitch()) {
            throw new RuntimeException("key param is null");
        }
    }

    @Override // d.a.j0.e1.t.a
    public void i(ChatSetting chatSetting, n<Void> nVar) {
        if (chatSetting == null || !(chatSetting instanceof OfficialSettingItemData)) {
            return;
        }
        OfficialSettingItemData officialSettingItemData = (OfficialSettingItemData) chatSetting;
        String myUid = officialSettingItemData.getMyUid();
        String toUid = officialSettingItemData.getToUid();
        if (!TextUtils.isEmpty(myUid) && !TextUtils.isEmpty(toUid)) {
            String str = myUid + "@" + toUid;
            synchronized (this.f53842a) {
                this.f53842a.put(str, officialSettingItemData);
            }
            h0.c(new a(officialSettingItemData, str), nVar);
        } else if (TbConfig.getDebugSwitch()) {
            throw new RuntimeException("key param is null");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.e1.t.a
    /* renamed from: k */
    public OfficialSettingItemData a(String str, String str2) {
        OfficialSettingItemData officialSettingItemData = null;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.f53842a) {
            ChatSetting chatSetting = this.f53842a.get(str3);
            if (chatSetting != null && (chatSetting instanceof OfficialSettingItemData)) {
                officialSettingItemData = (OfficialSettingItemData) chatSetting;
            }
        }
        if (officialSettingItemData == null) {
            OfficialSettingItemData officialSettingItemData2 = new OfficialSettingItemData();
            officialSettingItemData2.setMyUid(str);
            officialSettingItemData2.setToUid(str2);
            officialSettingItemData2.setAcceptNotify(true);
            return officialSettingItemData2;
        }
        return officialSettingItemData;
    }

    public void l() {
        super.e(OfficialSettingItemData.class);
    }

    public void m(String str, String str2, UserData userData) {
        OfficialSettingItemData a2;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || userData == null || (a2 = a(str, str2)) == null) {
            return;
        }
        a2.setToPortrait(userData.getPortrait());
        a2.setToName(userData.getUserName());
        h(a2);
    }
}
