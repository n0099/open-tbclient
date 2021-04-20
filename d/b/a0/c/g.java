package d.b.a0.c;

import android.net.Uri;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g implements Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public String f41883e;

    /* renamed from: f  reason: collision with root package name */
    public Uri f41884f;

    /* renamed from: h  reason: collision with root package name */
    public String[] f41886h;
    public HashMap<String, String> i;
    public g k;
    public JSONObject m;
    public String n;

    /* renamed from: g  reason: collision with root package name */
    public int f41885g = -1;
    public boolean j = false;
    public boolean l = false;

    static {
        String str = c.b() + "://";
    }

    public g(Uri uri, String str) {
        this.f41883e = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.f41883e = str;
        this.f41884f = uri;
        this.f41886h = j.c(uri);
        this.i = j.b(uri.toString());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: b */
    public g clone() {
        Uri uri = this.f41884f;
        g gVar = new g(uri, this.f41883e, j.c(uri), (HashMap) this.i.clone());
        gVar.k = this;
        gVar.l = this.l;
        gVar.n = this.n;
        return gVar;
    }

    public String c() {
        String path;
        Uri uri = this.f41884f;
        if (uri != null) {
            if (j.d(uri) && (path = this.f41884f.getPath()) != null && path.length() > 1) {
                return this.f41884f.getPath().substring(1);
            }
            return this.f41884f.getHost() + this.f41884f.getPath();
        }
        return "";
    }

    public HashMap<String, String> d() {
        return this.i;
    }

    public String e(boolean z) {
        if (this.f41886h != null) {
            if (z) {
                this.f41885g++;
            }
            int i = this.f41885g;
            String[] strArr = this.f41886h;
            if (i < strArr.length) {
                return strArr[i];
            }
            return null;
        }
        return null;
    }

    public Uri f() {
        return this.f41884f;
    }

    public boolean g() {
        return this.j;
    }

    public void h(String str, String str2) {
        Uri uri = this.f41884f;
        if (uri == null || str == null || str2 == null) {
            return;
        }
        Uri parse = Uri.parse(uri.toString().replace(str, str2));
        this.f41884f = parse;
        this.f41886h = j.c(parse);
    }

    public void i(boolean z) {
        this.j = z;
    }

    public g(Uri uri, String str, String[] strArr, HashMap<String, String> hashMap) {
        this.f41883e = UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE;
        this.f41884f = uri;
        this.f41883e = str;
        this.f41886h = strArr;
        this.i = hashMap;
    }
}
