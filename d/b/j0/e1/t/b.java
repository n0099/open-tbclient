package d.b.j0.e1.t;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.im.pushNotify.ChatSetting;
import com.baidu.tieba.im.settingcache.GroupSettingItemData;
import d.b.c.e.d.l;
import d.b.i0.z0.f0;
import d.b.i0.z0.h0;
import d.b.i0.z0.n;
/* loaded from: classes4.dex */
public class b extends d.b.j0.e1.t.a {

    /* renamed from: b  reason: collision with root package name */
    public static b f55978b = new b();

    /* loaded from: classes4.dex */
    public class a extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f55979a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f55980b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f55981c;

        public a(String str, String str2, long j) {
            this.f55979a = str;
            this.f55980b = str2;
            this.f55981c = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.b.i0.z0.f0
        public Boolean doInBackground() {
            GroupSettingItemData a2 = b.this.a(this.f55979a, this.f55980b);
            if (a2 != null && a2.isAlreadyApply()) {
                if (System.currentTimeMillis() - a2.getLastApplyTimeStamp() <= this.f55981c) {
                    return Boolean.FALSE;
                }
            }
            return Boolean.TRUE;
        }
    }

    /* renamed from: d.b.j0.e1.t.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1300b extends f0<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GroupSettingItemData f55983a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f55984b;

        public C1300b(GroupSettingItemData groupSettingItemData, String str) {
            this.f55983a = groupSettingItemData;
            this.f55984b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            b.this.b().g(this.f55984b, OrmObject.jsonStrWithObject(this.f55983a));
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends f0<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f55986a;

        public c(String str) {
            this.f55986a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            b.this.b().remove(this.f55986a);
            return null;
        }
    }

    public static b k() {
        return f55978b;
    }

    @Override // d.b.j0.e1.t.a
    public l<String> b() {
        return d.b.i0.r.r.a.f().g("tb.im_group_setting");
    }

    @Override // d.b.j0.e1.t.a
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
            synchronized (this.f55974a) {
                this.f55974a.put(str, groupSettingItemData);
            }
            b2.g(str, jsonStrWithObject);
        } else if (TbConfig.getDebugSwitch()) {
            throw new RuntimeException("key param is null");
        }
    }

    @Override // d.b.j0.e1.t.a
    public void i(ChatSetting chatSetting, n<Void> nVar) {
        if (chatSetting == null || !(chatSetting instanceof GroupSettingItemData)) {
            return;
        }
        GroupSettingItemData groupSettingItemData = (GroupSettingItemData) chatSetting;
        String uid = groupSettingItemData.getUid();
        String gid = groupSettingItemData.getGid();
        if (!TextUtils.isEmpty(uid) && !TextUtils.isEmpty(gid)) {
            String str = uid + "@" + gid;
            synchronized (this.f55974a) {
                this.f55974a.put(str, groupSettingItemData);
            }
            h0.c(new C1300b(groupSettingItemData, str), nVar);
        } else if (TbConfig.getDebugSwitch()) {
            throw new RuntimeException("key param is null");
        }
    }

    public void j(String str, String str2, n<Void> nVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String str3 = str + "@" + str2;
        synchronized (this.f55974a) {
            this.f55974a.remove(str3);
        }
        h0.c(new c(str3), nVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.e1.t.a
    /* renamed from: l */
    public GroupSettingItemData a(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.f55974a) {
            ChatSetting chatSetting = this.f55974a.get(str3);
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
