package d.a.b0.c;

import android.net.Uri;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public String f38601e;

    /* renamed from: f  reason: collision with root package name */
    public Uri f38602f;

    /* renamed from: h  reason: collision with root package name */
    public String[] f38604h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f38605i;
    public g k;
    public JSONObject m;
    public String n;

    /* renamed from: g  reason: collision with root package name */
    public int f38603g = -1;
    public boolean j = false;
    public boolean l = false;

    static {
        String str = c.b() + "://";
    }

    public g(Uri uri, String str) {
        this.f38601e = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.f38601e = str;
        this.f38602f = uri;
        this.f38604h = j.c(uri);
        this.f38605i = j.b(uri.toString());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: b */
    public g clone() {
        Uri uri = this.f38602f;
        g gVar = new g(uri, this.f38601e, j.c(uri), (HashMap) this.f38605i.clone());
        gVar.k = this;
        gVar.l = this.l;
        gVar.n = this.n;
        return gVar;
    }

    public String c() {
        String path;
        Uri uri = this.f38602f;
        if (uri != null) {
            if (j.d(uri) && (path = this.f38602f.getPath()) != null && path.length() > 1) {
                return this.f38602f.getPath().substring(1);
            }
            return this.f38602f.getHost() + this.f38602f.getPath();
        }
        return "";
    }

    public HashMap<String, String> d() {
        return this.f38605i;
    }

    public String e(boolean z) {
        if (this.f38604h != null) {
            if (z) {
                this.f38603g++;
            }
            int i2 = this.f38603g;
            String[] strArr = this.f38604h;
            if (i2 < strArr.length) {
                return strArr[i2];
            }
            return null;
        }
        return null;
    }

    public Uri f() {
        return this.f38602f;
    }

    public boolean g() {
        return this.j;
    }

    public void h(String str, String str2) {
        Uri uri = this.f38602f;
        if (uri == null || str == null || str2 == null) {
            return;
        }
        Uri parse = Uri.parse(uri.toString().replace(str, str2));
        this.f38602f = parse;
        this.f38604h = j.c(parse);
    }

    public void i(boolean z) {
        this.j = z;
    }

    public g(Uri uri, String str, String[] strArr, HashMap<String, String> hashMap) {
        this.f38601e = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.f38602f = uri;
        this.f38601e = str;
        this.f38604h = strArr;
        this.f38605i = hashMap;
    }
}
