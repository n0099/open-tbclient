package d.a.j0.r.q;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.WriteData;
import java.util.Objects;
/* loaded from: classes3.dex */
public class i1 {

    /* renamed from: a  reason: collision with root package name */
    public final long f50008a;

    /* renamed from: b  reason: collision with root package name */
    public String f50009b = "0";

    /* renamed from: c  reason: collision with root package name */
    public int f50010c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50011d;

    static {
        MessageManager.getInstance().registerStickyMode(2921526);
    }

    public i1(long j) {
        this.f50008a = j;
    }

    public static i1 g(@NonNull WriteData writeData, int i2) {
        i1 i1Var = new i1(writeData.startPublishTime());
        if (!TextUtils.isEmpty(writeData.getForumId())) {
            i1Var.f50009b = writeData.getForumId();
        }
        i1Var.f50010c = i2;
        return i1Var;
    }

    public int a() {
        return this.f50010c;
    }

    public void b() {
        this.f50011d = false;
    }

    public boolean c(String str) {
        return this.f50009b.equals(str);
    }

    public boolean d() {
        return this.f50011d;
    }

    public void e(boolean z) {
        this.f50011d = z;
        if (this.f50008a > 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921526, this));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i1) && this.f50008a == ((i1) obj).f50008a;
    }

    public void f(@NonNull i1 i1Var) {
        if (!i1Var.f50011d) {
            this.f50011d = false;
        }
        this.f50010c = i1Var.a();
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.f50008a));
    }
}
