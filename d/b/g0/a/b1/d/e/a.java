package d.b.g0.a.b1.d.e;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a implements Comparable<Object> {

    /* renamed from: e  reason: collision with root package name */
    public String f43445e;

    /* renamed from: f  reason: collision with root package name */
    public String f43446f;

    /* renamed from: g  reason: collision with root package name */
    public long f43447g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<MediaModel> f43448h;

    public void a(MediaModel mediaModel) {
        if (this.f43448h == null) {
            this.f43448h = new ArrayList<>();
        }
        this.f43448h.add(mediaModel);
    }

    public String b() {
        return this.f43446f;
    }

    public String c() {
        return this.f43445e;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return Long.valueOf(((a) obj).e()).compareTo(Long.valueOf(this.f43447g));
    }

    public int d() {
        return this.f43448h.size();
    }

    public long e() {
        return this.f43447g;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f43445e.equals(((a) obj).f43445e);
        }
        return false;
    }

    public ArrayList<MediaModel> f() {
        return this.f43448h;
    }

    public void g(String str) {
        this.f43446f = str;
    }

    public void h(String str) {
        this.f43445e = str;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void i(long j) {
        this.f43447g = j;
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.f43445e + ", imageCount=" + d() + "]";
    }
}
