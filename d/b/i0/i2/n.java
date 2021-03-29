package d.b.i0.i2;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.LinkedHashMap;
/* loaded from: classes5.dex */
public class n {

    /* renamed from: c  reason: collision with root package name */
    public static n f56160c;

    /* renamed from: a  reason: collision with root package name */
    public LinkedHashMap<String, Integer> f56161a = new LinkedHashMap<>(150, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f56162b = new a(2005016);

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            n.this.f56161a.clear();
        }
    }

    public n() {
        MessageManager.getInstance().registerListener(this.f56162b);
    }

    public static n d() {
        if (f56160c == null) {
            synchronized (n.class) {
                if (f56160c == null) {
                    f56160c = new n();
                }
            }
        }
        return f56160c;
    }

    public void b() {
        this.f56161a.clear();
    }

    public int c(String str) {
        Integer num = this.f56161a.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f56161a.remove(str);
    }

    public void f(String str, int i) {
        if (i == 0 && this.f56161a.containsKey(str)) {
            return;
        }
        this.f56161a.put(str, Integer.valueOf(i));
    }
}
