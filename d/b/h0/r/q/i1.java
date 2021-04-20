package d.b.h0.r.q;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.WriteData;
import java.util.Objects;
/* loaded from: classes3.dex */
public class i1 {

    /* renamed from: a  reason: collision with root package name */
    public final long f51224a;

    /* renamed from: b  reason: collision with root package name */
    public String f51225b = "0";

    /* renamed from: c  reason: collision with root package name */
    public int f51226c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f51227d;

    static {
        MessageManager.getInstance().registerStickyMode(2921526);
    }

    public i1(long j) {
        this.f51224a = j;
    }

    public static i1 g(@NonNull WriteData writeData, int i) {
        i1 i1Var = new i1(writeData.startPublishTime());
        if (!TextUtils.isEmpty(writeData.getForumId())) {
            i1Var.f51225b = writeData.getForumId();
        }
        i1Var.f51226c = i;
        return i1Var;
    }

    public int a() {
        return this.f51226c;
    }

    public void b() {
        this.f51227d = false;
    }

    public boolean c(String str) {
        return this.f51225b.equals(str);
    }

    public boolean d() {
        return this.f51227d;
    }

    public void e(boolean z) {
        this.f51227d = z;
        if (this.f51224a > 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921526, this));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i1) && this.f51224a == ((i1) obj).f51224a;
    }

    public void f(@NonNull i1 i1Var) {
        if (!i1Var.f51227d) {
            this.f51227d = false;
        }
        this.f51226c = i1Var.a();
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.f51224a));
    }
}
