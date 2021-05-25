package d.a.n0.k2;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.LinkedHashMap;
/* loaded from: classes5.dex */
public class n {

    /* renamed from: c  reason: collision with root package name */
    public static n f56894c;

    /* renamed from: a  reason: collision with root package name */
    public LinkedHashMap<String, Integer> f56895a = new LinkedHashMap<>(150, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f56896b = new a(2005016);

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
            n.this.f56895a.clear();
        }
    }

    public n() {
        MessageManager.getInstance().registerListener(this.f56896b);
    }

    public static n d() {
        if (f56894c == null) {
            synchronized (n.class) {
                if (f56894c == null) {
                    f56894c = new n();
                }
            }
        }
        return f56894c;
    }

    public void b() {
        this.f56895a.clear();
    }

    public int c(String str) {
        Integer num = this.f56895a.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f56895a.remove(str);
    }

    public void f(String str, int i2) {
        if (i2 == 0 && this.f56895a.containsKey(str)) {
            return;
        }
        this.f56895a.put(str, Integer.valueOf(i2));
    }
}
