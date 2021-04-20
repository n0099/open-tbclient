package d.b.i0.j2;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.LinkedHashMap;
/* loaded from: classes3.dex */
public class n {

    /* renamed from: c  reason: collision with root package name */
    public static n f57607c;

    /* renamed from: a  reason: collision with root package name */
    public LinkedHashMap<String, Integer> f57608a = new LinkedHashMap<>(150, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f57609b = new a(2005016);

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
            n.this.f57608a.clear();
        }
    }

    public n() {
        MessageManager.getInstance().registerListener(this.f57609b);
    }

    public static n d() {
        if (f57607c == null) {
            synchronized (n.class) {
                if (f57607c == null) {
                    f57607c = new n();
                }
            }
        }
        return f57607c;
    }

    public void b() {
        this.f57608a.clear();
    }

    public int c(String str) {
        Integer num = this.f57608a.get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f57608a.remove(str);
    }

    public void f(String str, int i) {
        if (i == 0 && this.f57608a.containsKey(str)) {
            return;
        }
        this.f57608a.put(str, Integer.valueOf(i));
    }
}
