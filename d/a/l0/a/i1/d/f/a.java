package d.a.l0.a.i1.d.f;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a implements Comparable<Object> {

    /* renamed from: e  reason: collision with root package name */
    public String f42888e;

    /* renamed from: f  reason: collision with root package name */
    public String f42889f;

    /* renamed from: g  reason: collision with root package name */
    public long f42890g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<MediaModel> f42891h;

    public void a(MediaModel mediaModel) {
        if (this.f42891h == null) {
            this.f42891h = new ArrayList<>();
        }
        this.f42891h.add(mediaModel);
    }

    public String b() {
        return this.f42889f;
    }

    public String c() {
        return this.f42888e;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return Long.valueOf(((a) obj).e()).compareTo(Long.valueOf(this.f42890g));
    }

    public int d() {
        return this.f42891h.size();
    }

    public long e() {
        return this.f42890g;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f42888e.equals(((a) obj).f42888e);
        }
        return false;
    }

    public ArrayList<MediaModel> f() {
        return this.f42891h;
    }

    public void g(String str) {
        this.f42889f = str;
    }

    public void h(String str) {
        this.f42888e = str;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void i(long j) {
        this.f42890g = j;
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.f42888e + ", imageCount=" + d() + "]";
    }
}
