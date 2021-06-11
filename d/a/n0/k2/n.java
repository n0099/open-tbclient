package d.a.n0.k2;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.LinkedHashMap;
/* loaded from: classes5.dex */
public class n {

    /* renamed from: c  reason: collision with root package name */
    public static n f60583c;

    /* renamed from: a  reason: collision with root package name */
    public LinkedHashMap<String, Integer> f60584a = new LinkedHashMap<>(150, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f60585b = new a(2005016);

    /* loaded from: classes5.dex */
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
            n.this.f60584a.clear();
        }
    }

    public n() {
        MessageManager.getInstance().registerListener(this.f60585b);
    }

    public static n d() {
        if (f60583c == null) {
            synchronized (n.class) {
                if (f60583c == null) {
                    f60583c = new n();
                }
            }
        }
        return f60583c;
    }

    public void b() {
        this.f60584a.clear();
    }

    public int c(String str) {
        Integer num = this.f60584a.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f60584a.remove(str);
    }

    public void f(String str, int i2) {
        if (i2 == 0 && this.f60584a.containsKey(str)) {
            return;
        }
        this.f60584a.put(str, Integer.valueOf(i2));
    }
}
