package d.a.n0.r.q;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.WriteData;
import java.util.Objects;
/* loaded from: classes3.dex */
public class i1 {

    /* renamed from: a  reason: collision with root package name */
    public final long f53835a;

    /* renamed from: b  reason: collision with root package name */
    public String f53836b = "0";

    /* renamed from: c  reason: collision with root package name */
    public int f53837c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f53838d;

    static {
        MessageManager.getInstance().registerStickyMode(2921526);
    }

    public i1(long j) {
        this.f53835a = j;
    }

    public static i1 g(@NonNull WriteData writeData, int i2) {
        i1 i1Var = new i1(writeData.startPublishTime());
        if (!TextUtils.isEmpty(writeData.getForumId())) {
            i1Var.f53836b = writeData.getForumId();
        }
        i1Var.f53837c = i2;
        return i1Var;
    }

    public int a() {
        return this.f53837c;
    }

    public void b() {
        this.f53838d = false;
    }

    public boolean c(String str) {
        return this.f53836b.equals(str);
    }

    public boolean d() {
        return this.f53838d;
    }

    public void e(boolean z) {
        this.f53838d = z;
        if (this.f53835a > 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921526, this));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i1) && this.f53835a == ((i1) obj).f53835a;
    }

    public void f(@NonNull i1 i1Var) {
        if (!i1Var.f53838d) {
            this.f53838d = false;
        }
        this.f53837c = i1Var.a();
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.f53835a));
    }
}
