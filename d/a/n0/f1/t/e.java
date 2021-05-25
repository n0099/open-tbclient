package d.a.n0.f1.t;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import d.a.c.e.d.l;
import d.a.m0.z0.f0;
import d.a.m0.z0.h0;
import d.a.m0.z0.n;
/* loaded from: classes4.dex */
public class e extends d.a.n0.f1.t.a {

    /* renamed from: b  reason: collision with root package name */
    public static e f54759b = new e();

    /* loaded from: classes4.dex */
    public class a extends f0<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalSettingItemData f54760a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f54761b;

        public a(PersonalSettingItemData personalSettingItemData, String str) {
            this.f54760a = personalSettingItemData;
            this.f54761b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            e.this.b().g(this.f54761b, OrmObject.jsonStrWithObject(this.f54760a));
            return null;
        }
    }

    public static e j() {
        return f54759b;
    }

    @Override // d.a.n0.f1.t.a
    public l<String> b() {
        return d.a.m0.r.r.a.f().g("tb.im_personal_chat_setting");
    }

    @Override // d.a.n0.f1.t.a
    public void h(ChatSetting chatSetting) {
        if (chatSetting == null || !(chatSetting instanceof PersonalSettingItemData)) {
            return;
        }
        PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) chatSetting;
        String myUid = personalSettingItemData.getMyUid();
        String toUid = personalSettingItemData.getToUid();
        if (!TextUtils.isEmpty(myUid) && !TextUtils.isEmpty(toUid)) {
            l<String> b2 = b();
            String str = myUid + "@" + toUid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(personalSettingItemData);
            synchronized (this.f54739a) {
                this.f54739a.put(str, personalSettingItemData);
            }
            b2.g(str, jsonStrWithObject);
        } else if (TbConfig.getDebugSwitch()) {
            throw new RuntimeException("key param is null");
        }
    }

    @Override // d.a.n0.f1.t.a
    public void i(ChatSetting chatSetting, n<Void> nVar) {
        if (chatSetting == null || !(chatSetting instanceof PersonalSettingItemData)) {
            return;
        }
        PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) chatSetting;
        String myUid = personalSettingItemData.getMyUid();
        String toUid = personalSettingItemData.getToUid();
        if (!TextUtils.isEmpty(myUid) && !TextUtils.isEmpty(toUid)) {
            String str = myUid + "@" + toUid;
            synchronized (this.f54739a) {
                this.f54739a.put(str, personalSettingItemData);
            }
            h0.c(new a(personalSettingItemData, str), nVar);
        } else if (TbConfig.getDebugSwitch()) {
            throw new RuntimeException("key param is null");
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.f1.t.a
    /* renamed from: k */
    public PersonalSettingItemData a(String str, String str2) {
        PersonalSettingItemData personalSettingItemData = null;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.f54739a) {
            ChatSetting chatSetting = this.f54739a.get(str3);
            if (chatSetting != null && (chatSetting instanceof PersonalSettingItemData)) {
                personalSettingItemData = (PersonalSettingItemData) chatSetting;
            }
        }
        if (personalSettingItemData == null) {
            PersonalSettingItemData personalSettingItemData2 = new PersonalSettingItemData();
            personalSettingItemData2.setMyUid(str);
            personalSettingItemData2.setToUid(str2);
            personalSettingItemData2.setAcceptNotify(true);
            return personalSettingItemData2;
        }
        return personalSettingItemData;
    }

    public void l() {
        super.e(PersonalSettingItemData.class);
    }

    public void m(String str, String str2, UserData userData) {
        PersonalSettingItemData a2;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || userData == null || (a2 = a(str, str2)) == null) {
            return;
        }
        a2.setToPortrait(userData.getPortrait());
        a2.setToName(userData.getUserName());
        h(a2);
    }
}
