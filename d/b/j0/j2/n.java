package d.b.j0.j2;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.LinkedHashMap;
/* loaded from: classes3.dex */
public class n {

    /* renamed from: c  reason: collision with root package name */
    public static n f58028c;

    /* renamed from: a  reason: collision with root package name */
    public LinkedHashMap<String, Integer> f58029a = new LinkedHashMap<>(150, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f58030b = new a(2005016);

    /* loaded from: classes3.dex */
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
            n.this.f58029a.clear();
        }
    }

    public n() {
        MessageManager.getInstance().registerListener(this.f58030b);
    }

    public static n d() {
        if (f58028c == null) {
            synchronized (n.class) {
                if (f58028c == null) {
                    f58028c = new n();
                }
            }
        }
        return f58028c;
    }

    public void b() {
        this.f58029a.clear();
    }

    public int c(String str) {
        Integer num = this.f58029a.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f58029a.remove(str);
    }

    public void f(String str, int i) {
        if (i == 0 && this.f58029a.containsKey(str)) {
            return;
        }
        this.f58029a.put(str, Integer.valueOf(i));
    }
}
