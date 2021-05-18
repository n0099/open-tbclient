package d.a.i0.a.i1.d.f;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a implements Comparable<Object> {

    /* renamed from: e  reason: collision with root package name */
    public String f42714e;

    /* renamed from: f  reason: collision with root package name */
    public String f42715f;

    /* renamed from: g  reason: collision with root package name */
    public long f42716g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<MediaModel> f42717h;

    public void a(MediaModel mediaModel) {
        if (this.f42717h == null) {
            this.f42717h = new ArrayList<>();
        }
        this.f42717h.add(mediaModel);
    }

    public String b() {
        return this.f42715f;
    }

    public String c() {
        return this.f42714e;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return Long.valueOf(((a) obj).e()).compareTo(Long.valueOf(this.f42716g));
    }

    public int d() {
        return this.f42717h.size();
    }

    public long e() {
        return this.f42716g;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f42714e.equals(((a) obj).f42714e);
        }
        return false;
    }

    public ArrayList<MediaModel> f() {
        return this.f42717h;
    }

    public void g(String str) {
        this.f42715f = str;
    }

    public void h(String str) {
        this.f42714e = str;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void i(long j) {
        this.f42716g = j;
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.f42714e + ", imageCount=" + d() + "]";
    }
}
