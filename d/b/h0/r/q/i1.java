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
    public final long f50816a;

    /* renamed from: b  reason: collision with root package name */
    public String f50817b = "0";

    /* renamed from: c  reason: collision with root package name */
    public int f50818c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50819d;

    static {
        MessageManager.getInstance().registerStickyMode(2921526);
    }

    public i1(long j) {
        this.f50816a = j;
    }

    public static i1 g(@NonNull WriteData writeData, int i) {
        i1 i1Var = new i1(writeData.startPublishTime());
        if (!TextUtils.isEmpty(writeData.getForumId())) {
            i1Var.f50817b = writeData.getForumId();
        }
        i1Var.f50818c = i;
        return i1Var;
    }

    public int a() {
        return this.f50818c;
    }

    public void b() {
        this.f50819d = false;
    }

    public boolean c(String str) {
        return this.f50817b.equals(str);
    }

    public boolean d() {
        return this.f50819d;
    }

    public void e(boolean z) {
        this.f50819d = z;
        if (this.f50816a > 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921526, this));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i1) && this.f50816a == ((i1) obj).f50816a;
    }

    public void f(@NonNull i1 i1Var) {
        if (!i1Var.f50819d) {
            this.f50819d = false;
        }
        this.f50818c = i1Var.a();
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.f50816a));
    }
}
