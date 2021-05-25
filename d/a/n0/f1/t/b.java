package d.a.n0.f1.t;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import d.a.c.e.d.l;
import d.a.m0.z0.f0;
import d.a.m0.z0.h0;
import d.a.m0.z0.n;
/* loaded from: classes4.dex */
public class b extends d.a.n0.f1.t.a {

    /* renamed from: b  reason: collision with root package name */
    public static b f54743b = new b();

    /* loaded from: classes4.dex */
    public class a extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f54744a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f54745b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f54746c;

        public a(String str, String str2, long j) {
            this.f54744a = str;
            this.f54745b = str2;
            this.f54746c = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.m0.z0.f0
        public Boolean doInBackground() {
            GroupSettingItemData a2 = b.this.a(this.f54744a, this.f54745b);
            if (a2 != null && a2.isAlreadyApply()) {
                if (System.currentTimeMillis() - a2.getLastApplyTimeStamp() <= this.f54746c) {
                    return Boolean.FALSE;
                }
            }
            return Boolean.TRUE;
        }
    }

    /* renamed from: d.a.n0.f1.t.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1329b extends f0<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupSettingItemData f54748a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f54749b;

        public C1329b(GroupSettingItemData groupSettingItemData, String str) {
            this.f54748a = groupSettingItemData;
            this.f54749b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            b.this.b().g(this.f54749b, OrmObject.jsonStrWithObject(this.f54748a));
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends f0<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f54751a;

        public c(String str) {
            this.f54751a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            b.this.b().remove(this.f54751a);
            return null;
        }
    }

    public static b k() {
        return f54743b;
    }

    @Override // d.a.n0.f1.t.a
    public l<String> b() {
        return d.a.m0.r.r.a.f().g("tb.im_group_setting");
    }

    @Override // d.a.n0.f1.t.a
    public void h(ChatSetting chatSetting) {
        if (chatSetting == null || !(chatSetting instanceof GroupSettingItemData)) {
            return;
        }
        GroupSettingItemData groupSettingItemData = (GroupSettingItemData) chatSetting;
        String uid = groupSettingItemData.getUid();
        String gid = groupSettingItemData.getGid();
        if (!TextUtils.isEmpty(uid) && !TextUtils.isEmpty(gid)) {
            l<String> b2 = b();
            String str = uid + "@" + gid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
            synchronized (this.f54739a) {
                this.f54739a.put(str, groupSettingItemData);
            }
            b2.g(str, jsonStrWithObject);
        } else if (TbConfig.getDebugSwitch()) {
            throw new RuntimeException("key param is null");
        }
    }

    @Override // d.a.n0.f1.t.a
    public void i(ChatSetting chatSetting, n<Void> nVar) {
        if (chatSetting == null || !(chatSetting instanceof GroupSettingItemData)) {
            return;
        }
        GroupSettingItemData groupSettingItemData = (GroupSettingItemData) chatSetting;
        String uid = groupSettingItemData.getUid();
        String gid = groupSettingItemData.getGid();
        if (!TextUtils.isEmpty(uid) && !TextUtils.isEmpty(gid)) {
            String str = uid + "@" + gid;
            synchronized (this.f54739a) {
                this.f54739a.put(str, groupSettingItemData);
            }
            h0.c(new C1329b(groupSettingItemData, str), nVar);
        } else if (TbConfig.getDebugSwitch()) {
            throw new RuntimeException("key param is null");
        }
    }

    public void j(String str, String str2, n<Void> nVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String str3 = str + "@" + str2;
        synchronized (this.f54739a) {
            this.f54739a.remove(str3);
        }
        h0.c(new c(str3), nVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.f1.t.a
    /* renamed from: l */
    public GroupSettingItemData a(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.f54739a) {
            ChatSetting chatSetting = this.f54739a.get(str3);
            groupSettingItemData = chatSetting instanceof GroupSettingItemData ? (GroupSettingItemData) chatSetting : null;
        }
        if (groupSettingItemData == null) {
            GroupSettingItemData groupSettingItemData2 = new GroupSettingItemData();
            groupSettingItemData2.setUid(str);
            groupSettingItemData2.setGid(str2);
            groupSettingItemData2.setAcceptNotify(true);
            groupSettingItemData2.setInGroup(true);
            return groupSettingItemData2;
        }
        return groupSettingItemData;
    }

    public void m(String str, String str2, long j, n<Boolean> nVar) {
        h0.c(new a(str, str2, j), nVar);
    }

    public void n() {
        super.e(GroupSettingItemData.class);
    }

    public void o(String str, String str2, boolean z, n<Void> nVar) {
        GroupSettingItemData a2 = a(str, str2);
        if (a2 == null) {
            return;
        }
        a2.setAlreadyApply(z);
        a2.setLastApplyTimeStamp(System.currentTimeMillis());
        i(a2, nVar);
    }

    public void p(String str, String str2, boolean z, n<Void> nVar) {
        GroupSettingItemData a2 = a(str, str2);
        if (a2 == null) {
            return;
        }
        a2.setInGroup(z);
        i(a2, nVar);
    }
}
