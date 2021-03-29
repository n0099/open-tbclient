package d.b.i0.y2;

import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d implements PreLoadImageProvider {

    /* renamed from: e  reason: collision with root package name */
    public int f62616e;

    /* renamed from: f  reason: collision with root package name */
    public String f62617f;

    /* renamed from: g  reason: collision with root package name */
    public String f62618g;

    /* renamed from: h  reason: collision with root package name */
    public int f62619h;
    public int i;
    public int j;
    public int k;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;

    public String a() {
        return this.f62618g;
    }

    public int b() {
        return this.i;
    }

    public int c() {
        return this.f62616e;
    }

    public String d() {
        return this.f62617f;
    }

    public int e() {
        return this.q;
    }

    public int f() {
        return this.f62619h;
    }

    public int g() {
        return this.l;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
        preLoadImageInfo.imgUrl = this.f62618g;
        preLoadImageInfo.procType = 10;
        arrayList.add(preLoadImageInfo);
        return arrayList;
    }

    public int h() {
        return this.k;
    }

    public int i() {
        return this.j;
    }

    public boolean j() {
        return this.o;
    }

    public boolean k() {
        return this.p;
    }

    public boolean l() {
        return this.m;
    }

    public boolean m() {
        return this.n;
    }

    public void n(JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        this.f62616e = jSONObject.optInt("forum_id");
        this.f62617f = jSONObject.optString("forum_name");
        this.f62618g = jSONObject.optString("avatar");
        this.f62619h = jSONObject.optInt("is_sign_in");
        this.i = jSONObject.optInt("cont_sign_num");
        this.j = jSONObject.optInt(IntentConfig.USER_LEVEL);
        this.k = jSONObject.optInt("user_exp");
        this.l = jSONObject.optInt("need_exp");
        if (this.f62619h != 0) {
            this.m = true;
            this.o = false;
        }
    }

    public void o(int i) {
        this.i = i;
    }

    public void p(String str) {
    }

    public void q(int i) {
        this.q = i;
    }

    public void r(int i) {
        this.f62619h = i;
    }

    public void s(boolean z) {
        this.o = z;
        this.f62619h = 0;
    }

    public void t(boolean z) {
        this.p = z;
    }

    public void u(boolean z) {
        this.m = z;
        this.f62619h = 1;
    }

    public void v(boolean z) {
        this.n = z;
    }

    public void w(int i) {
        this.j = i;
    }
}
