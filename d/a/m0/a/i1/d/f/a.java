package d.a.m0.a.i1.d.f;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a implements Comparable<Object> {

    /* renamed from: e  reason: collision with root package name */
    public String f46672e;

    /* renamed from: f  reason: collision with root package name */
    public String f46673f;

    /* renamed from: g  reason: collision with root package name */
    public long f46674g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<MediaModel> f46675h;

    public void a(MediaModel mediaModel) {
        if (this.f46675h == null) {
            this.f46675h = new ArrayList<>();
        }
        this.f46675h.add(mediaModel);
    }

    public String b() {
        return this.f46673f;
    }

    public String c() {
        return this.f46672e;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return Long.valueOf(((a) obj).e()).compareTo(Long.valueOf(this.f46674g));
    }

    public int d() {
        return this.f46675h.size();
    }

    public long e() {
        return this.f46674g;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f46672e.equals(((a) obj).f46672e);
        }
        return false;
    }

    public ArrayList<MediaModel> f() {
        return this.f46675h;
    }

    public void g(String str) {
        this.f46673f = str;
    }

    public void h(String str) {
        this.f46672e = str;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void i(long j) {
        this.f46674g = j;
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.f46672e + ", imageCount=" + d() + PreferencesUtil.RIGHT_MOUNT;
    }
}
