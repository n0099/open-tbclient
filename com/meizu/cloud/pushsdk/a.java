package com.meizu.cloud.pushsdk;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.handler.a.b;
import com.meizu.cloud.pushsdk.handler.a.d;
import com.meizu.cloud.pushsdk.handler.a.e;
import com.meizu.cloud.pushsdk.handler.a.f;
import com.meizu.cloud.pushsdk.handler.c;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    public static volatile a a;

    /* renamed from: b  reason: collision with root package name */
    public Context f60150b;

    /* renamed from: c  reason: collision with root package name */
    public Map<Integer, c> f60151c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, com.meizu.cloud.pushsdk.handler.a> f60152d;

    /* renamed from: com.meizu.cloud.pushsdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C2081a extends com.meizu.cloud.pushsdk.handler.a {
        public C2081a() {
        }

        @Override // com.meizu.cloud.pushsdk.handler.a
        public void a(Context context, Intent intent) {
            for (Map.Entry entry : a.this.f60152d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.a(context, intent);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(Context context, MzPushMessage mzPushMessage) {
            for (Map.Entry entry : a.this.f60152d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.a(context, mzPushMessage);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(Context context, PushSwitchStatus pushSwitchStatus) {
            for (Map.Entry entry : a.this.f60152d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.a(context, pushSwitchStatus);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(Context context, RegisterStatus registerStatus) {
            for (Map.Entry entry : a.this.f60152d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.a(context, registerStatus);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(Context context, SubAliasStatus subAliasStatus) {
            for (Map.Entry entry : a.this.f60152d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.a(context, subAliasStatus);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(Context context, SubTagsStatus subTagsStatus) {
            for (Map.Entry entry : a.this.f60152d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.a(context, subTagsStatus);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(Context context, UnRegisterStatus unRegisterStatus) {
            for (Map.Entry entry : a.this.f60152d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.a(context, unRegisterStatus);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(Context context, String str) {
            for (Map.Entry entry : a.this.f60152d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.a(context, str);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(Context context, String str, String str2) {
            for (Map.Entry entry : a.this.f60152d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.a(context, str, str2);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(Context context, boolean z) {
            for (Map.Entry entry : a.this.f60152d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.a(context, z);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void a(PushNotificationBuilder pushNotificationBuilder) {
            for (Map.Entry entry : a.this.f60152d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.a(pushNotificationBuilder);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void b(Context context, MzPushMessage mzPushMessage) {
            for (Map.Entry entry : a.this.f60152d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.b(context, mzPushMessage);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void b(Context context, String str) {
            for (Map.Entry entry : a.this.f60152d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.b(context, str);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void c(Context context, MzPushMessage mzPushMessage) {
            for (Map.Entry entry : a.this.f60152d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.c(context, mzPushMessage);
                }
            }
        }

        @Override // com.meizu.cloud.pushsdk.handler.b
        public void c(Context context, String str) {
            for (Map.Entry entry : a.this.f60152d.entrySet()) {
                com.meizu.cloud.pushsdk.handler.a aVar = (com.meizu.cloud.pushsdk.handler.a) entry.getValue();
                if (aVar != null) {
                    aVar.c(context, str);
                }
            }
        }
    }

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, List<c> list) {
        this(context, list, null);
    }

    public a(Context context, List<c> list, com.meizu.cloud.pushsdk.handler.a aVar) {
        this.f60151c = new HashMap();
        this.f60152d = null;
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null.");
        }
        this.f60150b = context.getApplicationContext();
        this.f60152d = new HashMap();
        C2081a c2081a = new C2081a();
        if (list != null) {
            a(list);
            return;
        }
        a(new com.meizu.cloud.pushsdk.handler.a.c(context, c2081a));
        a(new b(context, c2081a));
        a(new e(context, c2081a));
        a(new com.meizu.cloud.pushsdk.handler.a.c.b(context, c2081a));
        a(new d(context, c2081a));
        a(new f(context, c2081a));
        a(new com.meizu.cloud.pushsdk.handler.a.c.c(context, c2081a));
        a(new com.meizu.cloud.pushsdk.handler.a.d.a(context, c2081a));
        a(new com.meizu.cloud.pushsdk.handler.a.d.c(context, c2081a));
        a(new com.meizu.cloud.pushsdk.handler.a.d.f(context, c2081a));
        a(new com.meizu.cloud.pushsdk.handler.a.d.d(context, c2081a));
        a(new com.meizu.cloud.pushsdk.handler.a.d.e(context, c2081a));
        a(new com.meizu.cloud.pushsdk.handler.a.e.a(context, c2081a));
        a(new com.meizu.cloud.pushsdk.handler.a.d.b(context, c2081a));
        a(new com.meizu.cloud.pushsdk.handler.a.c.d(context, c2081a));
        a(new com.meizu.cloud.pushsdk.handler.a.a.a(context, c2081a));
        a(new com.meizu.cloud.pushsdk.handler.a.c.a(context, c2081a));
        a(new com.meizu.cloud.pushsdk.handler.a.c.e(context, c2081a));
    }

    public static a a(Context context) {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    c.k.a.a.a.d("PushMessageProxy", "PushMessageProxy init");
                    a = new a(context);
                }
            }
        }
        return a;
    }

    public a a(c cVar) {
        this.f60151c.put(Integer.valueOf(cVar.a()), cVar);
        return this;
    }

    public a a(String str, com.meizu.cloud.pushsdk.handler.a aVar) {
        this.f60152d.put(str, aVar);
        return this;
    }

    public a a(List<c> list) {
        if (list != null) {
            for (c cVar : list) {
                a(cVar);
            }
            return this;
        }
        throw new IllegalArgumentException("messageManagerList must not be null.");
    }

    public void a(Intent intent) {
        c.k.a.a.a.b("PushMessageProxy", "is onMainThread " + a());
        try {
            String stringExtra = intent.getStringExtra("method");
            c.k.a.a.a.d("PushMessageProxy", "receive action " + intent.getAction() + " method " + stringExtra);
            if (intent != null) {
                Iterator<Map.Entry<Integer, c>> it = this.f60151c.entrySet().iterator();
                while (it.hasNext() && !it.next().getValue().b(intent)) {
                }
            }
        } catch (Exception e2) {
            c.k.a.a.a.b("PushMessageProxy", "processMessage error " + e2.getMessage());
        }
    }

    public boolean a() {
        return Thread.currentThread() == this.f60150b.getMainLooper().getThread();
    }
}
