package d.b.h0.a.b1.d.e;

import com.baidu.swan.apps.media.chooser.model.MediaModel;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a implements Comparable<Object> {

    /* renamed from: e  reason: collision with root package name */
    public String f44167e;

    /* renamed from: f  reason: collision with root package name */
    public String f44168f;

    /* renamed from: g  reason: collision with root package name */
    public long f44169g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<MediaModel> f44170h;

    public void a(MediaModel mediaModel) {
        if (this.f44170h == null) {
            this.f44170h = new ArrayList<>();
        }
        this.f44170h.add(mediaModel);
    }

    public String b() {
        return this.f44168f;
    }

    public String c() {
        return this.f44167e;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return Long.valueOf(((a) obj).e()).compareTo(Long.valueOf(this.f44169g));
    }

    public int d() {
        return this.f44170h.size();
    }

    public long e() {
        return this.f44169g;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f44167e.equals(((a) obj).f44167e);
        }
        return false;
    }

    public ArrayList<MediaModel> f() {
        return this.f44170h;
    }

    public void g(String str) {
        this.f44168f = str;
    }

    public void h(String str) {
        this.f44167e = str;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void i(long j) {
        this.f44169g = j;
    }

    public String toString() {
        return "MediaDir [firstImgPath=, dirName=" + this.f44167e + ", imageCount=" + d() + "]";
    }
}
