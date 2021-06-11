package d.a.m0.r.q;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.WriteData;
import java.util.Objects;
/* loaded from: classes3.dex */
public class i1 {

    /* renamed from: a  reason: collision with root package name */
    public final long f53728a;

    /* renamed from: b  reason: collision with root package name */
    public String f53729b = "0";

    /* renamed from: c  reason: collision with root package name */
    public int f53730c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f53731d;

    static {
        MessageManager.getInstance().registerStickyMode(2921526);
    }

    public i1(long j) {
        this.f53728a = j;
    }

    public static i1 g(@NonNull WriteData writeData, int i2) {
        i1 i1Var = new i1(writeData.startPublishTime());
        if (!TextUtils.isEmpty(writeData.getForumId())) {
            i1Var.f53729b = writeData.getForumId();
        }
        i1Var.f53730c = i2;
        return i1Var;
    }

    public int a() {
        return this.f53730c;
    }

    public void b() {
        this.f53731d = false;
    }

    public boolean c(String str) {
        return this.f53729b.equals(str);
    }

    public boolean d() {
        return this.f53731d;
    }

    public void e(boolean z) {
        this.f53731d = z;
        if (this.f53728a > 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921526, this));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i1) && this.f53728a == ((i1) obj).f53728a;
    }

    public void f(@NonNull i1 i1Var) {
        if (!i1Var.f53731d) {
            this.f53731d = false;
        }
        this.f53730c = i1Var.a();
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.f53728a));
    }
}
