package d.a.j0.j2;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.LinkedHashMap;
/* loaded from: classes4.dex */
public class n {

    /* renamed from: c  reason: collision with root package name */
    public static n f56007c;

    /* renamed from: a  reason: collision with root package name */
    public LinkedHashMap<String, Integer> f56008a = new LinkedHashMap<>(150, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f56009b = new a(2005016);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            n.this.f56008a.clear();
        }
    }

    public n() {
        MessageManager.getInstance().registerListener(this.f56009b);
    }

    public static n d() {
        if (f56007c == null) {
            synchronized (n.class) {
                if (f56007c == null) {
                    f56007c = new n();
                }
            }
        }
        return f56007c;
    }

    public void b() {
        this.f56008a.clear();
    }

    public int c(String str) {
        Integer num = this.f56008a.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f56008a.remove(str);
    }

    public void f(String str, int i2) {
        if (i2 == 0 && this.f56008a.containsKey(str)) {
            return;
        }
        this.f56008a.put(str, Integer.valueOf(i2));
    }
}
