package d.a.d0.c;

import android.net.Uri;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public String f43351e;

    /* renamed from: f  reason: collision with root package name */
    public Uri f43352f;

    /* renamed from: h  reason: collision with root package name */
    public String[] f43354h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<String, String> f43355i;
    public g k;
    public JSONObject m;
    public String n;

    /* renamed from: g  reason: collision with root package name */
    public int f43353g = -1;
    public boolean j = false;
    public boolean l = false;

    static {
        String str = c.b() + "://";
    }

    public g(Uri uri, String str) {
        this.f43351e = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.f43351e = str;
        this.f43352f = uri;
        this.f43354h = j.c(uri);
        this.f43355i = j.b(uri.toString());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: b */
    public g clone() {
        Uri uri = this.f43352f;
        g gVar = new g(uri, this.f43351e, j.c(uri), (HashMap) this.f43355i.clone());
        gVar.k = this;
        gVar.l = this.l;
        gVar.n = this.n;
        return gVar;
    }

    public String c() {
        String path;
        Uri uri = this.f43352f;
        if (uri != null) {
            if (j.d(uri) && (path = this.f43352f.getPath()) != null && path.length() > 1) {
                return this.f43352f.getPath().substring(1);
            }
            return this.f43352f.getHost() + this.f43352f.getPath();
        }
        return "";
    }

    public HashMap<String, String> d() {
        return this.f43355i;
    }

    public String e(boolean z) {
        if (this.f43354h != null) {
            if (z) {
                this.f43353g++;
            }
            int i2 = this.f43353g;
            String[] strArr = this.f43354h;
            if (i2 < strArr.length) {
                return strArr[i2];
            }
            return null;
        }
        return null;
    }

    public Uri f() {
        return this.f43352f;
    }

    public boolean g() {
        return this.j;
    }

    public void h(String str, String str2) {
        Uri uri = this.f43352f;
        if (uri == null || str == null || str2 == null) {
            return;
        }
        Uri parse = Uri.parse(uri.toString().replace(str, str2));
        this.f43352f = parse;
        this.f43354h = j.c(parse);
    }

    public void i(boolean z) {
        this.j = z;
    }

    public g(Uri uri, String str, String[] strArr, HashMap<String, String> hashMap) {
        this.f43351e = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.f43352f = uri;
        this.f43351e = str;
        this.f43354h = strArr;
        this.f43355i = hashMap;
    }
}
