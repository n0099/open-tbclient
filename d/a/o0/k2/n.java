package d.a.o0.k2;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.LinkedHashMap;
/* loaded from: classes5.dex */
public class n {

    /* renamed from: c  reason: collision with root package name */
    public static n f60708c;

    /* renamed from: a  reason: collision with root package name */
    public LinkedHashMap<String, Integer> f60709a = new LinkedHashMap<>(150, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f60710b = new a(2005016);

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
            n.this.f60709a.clear();
        }
    }

    public n() {
        MessageManager.getInstance().registerListener(this.f60710b);
    }

    public static n d() {
        if (f60708c == null) {
            synchronized (n.class) {
                if (f60708c == null) {
                    f60708c = new n();
                }
            }
        }
        return f60708c;
    }

    public void b() {
        this.f60709a.clear();
    }

    public int c(String str) {
        Integer num = this.f60709a.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f60709a.remove(str);
    }

    public void f(String str, int i2) {
        if (i2 == 0 && this.f60709a.containsKey(str)) {
            return;
        }
        this.f60709a.put(str, Integer.valueOf(i2));
    }
}
