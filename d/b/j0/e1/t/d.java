package d.b.j0.e1.t;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import d.b.c.e.d.l;
import d.b.i0.z0.f0;
import d.b.i0.z0.h0;
import d.b.i0.z0.n;
/* loaded from: classes4.dex */
public class d extends d.b.j0.e1.t.a {

    /* renamed from: b  reason: collision with root package name */
    public static d f55990b = new d();

    /* loaded from: classes4.dex */
    public class a extends f0<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialSettingItemData f55991a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f55992b;

        public a(OfficialSettingItemData officialSettingItemData, String str) {
            this.f55991a = officialSettingItemData;
            this.f55992b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            d.this.b().g(this.f55992b, OrmObject.jsonStrWithObject(this.f55991a));
            return null;
        }
    }

    public static d j() {
        return f55990b;
    }

    @Override // d.b.j0.e1.t.a
    public l<String> b() {
        return d.b.i0.r.r.a.f().g("tb.im_official_chat_setting");
    }

    @Override // d.b.j0.e1.t.a
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
            synchronized (this.f55974a) {
                this.f55974a.put(str, officialSettingItemData);
            }
            b2.g(str, jsonStrWithObject);
        } else if (TbConfig.getDebugSwitch()) {
            throw new RuntimeException("key param is null");
        }
    }

    @Override // d.b.j0.e1.t.a
    public void i(ChatSetting chatSetting, n<Void> nVar) {
        if (chatSetting == null || !(chatSetting instanceof OfficialSettingItemData)) {
            return;
        }
        OfficialSettingItemData officialSettingItemData = (OfficialSettingItemData) chatSetting;
        String myUid = officialSettingItemData.getMyUid();
        String toUid = officialSettingItemData.getToUid();
        if (!TextUtils.isEmpty(myUid) && !TextUtils.isEmpty(toUid)) {
            String str = myUid + "@" + toUid;
            synchronized (this.f55974a) {
                this.f55974a.put(str, officialSettingItemData);
            }
            h0.c(new a(officialSettingItemData, str), nVar);
        } else if (TbConfig.getDebugSwitch()) {
            throw new RuntimeException("key param is null");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.e1.t.a
    /* renamed from: k */
    public OfficialSettingItemData a(String str, String str2) {
        OfficialSettingItemData officialSettingItemData = null;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.f55974a) {
            ChatSetting chatSetting = this.f55974a.get(str3);
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
