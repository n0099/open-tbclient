package d.a.i0.r.q;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.WriteData;
import java.util.Objects;
/* loaded from: classes3.dex */
public class i1 {

    /* renamed from: a  reason: collision with root package name */
    public final long f49189a;

    /* renamed from: b  reason: collision with root package name */
    public String f49190b = "0";

    /* renamed from: c  reason: collision with root package name */
    public int f49191c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49192d;

    static {
        MessageManager.getInstance().registerStickyMode(2921526);
    }

    public i1(long j) {
        this.f49189a = j;
    }

    public static i1 g(@NonNull WriteData writeData, int i2) {
        i1 i1Var = new i1(writeData.startPublishTime());
        if (!TextUtils.isEmpty(writeData.getForumId())) {
            i1Var.f49190b = writeData.getForumId();
        }
        i1Var.f49191c = i2;
        return i1Var;
    }

    public int a() {
        return this.f49191c;
    }

    public void b() {
        this.f49192d = false;
    }

    public boolean c(String str) {
        return this.f49190b.equals(str);
    }

    public boolean d() {
        return this.f49192d;
    }

    public void e(boolean z) {
        this.f49192d = z;
        if (this.f49189a > 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921526, this));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i1) && this.f49189a == ((i1) obj).f49189a;
    }

    public void f(@NonNull i1 i1Var) {
        if (!i1Var.f49192d) {
            this.f49192d = false;
        }
        this.f49191c = i1Var.a();
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.f49189a));
    }
}
