package com.yy.hiidostatis.inner;

import android.content.Context;
import com.yy.hiidostatis.inner.FlushManager;
import com.yy.hiidostatis.inner.util.ProcessUtil;
import com.yy.hiidostatis.inner.util.log.L;
import java.util.Enumeration;
import java.util.Hashtable;
/* loaded from: classes8.dex */
public class GeneralProxy {
    public static FlushManager mFlushManager;
    public static Hashtable<String, GeneralStatisTool> statisToolContainer = new Hashtable<>();
    public static Hashtable<String, GeneralConfigTool> configToolContainer = new Hashtable<>();
    public static Object OBJ_KEY = FlushManager.class;

    public static synchronized void exit(Context context, boolean z) {
        synchronized (GeneralProxy.class) {
            try {
                Enumeration<GeneralStatisTool> elements = statisToolContainer.elements();
                while (elements.hasMoreElements()) {
                    GeneralStatisTool nextElement = elements.nextElement();
                    if (z) {
                        nextElement.getTaskManager().flush(context);
                    } else {
                        nextElement.getTaskManager().enableSend(z);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void flushCache(Context context, boolean z) {
        if (!z) {
            try {
                if (ProcessUtil.isBackground(context)) {
                    L.verbose("GeneralProxy", "app is Background ,no flush.", new Object[0]);
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        Enumeration<GeneralStatisTool> elements = statisToolContainer.elements();
        while (elements.hasMoreElements()) {
            elements.nextElement().getTaskManager().flush(context);
        }
    }

    public static GeneralConfigTool getGeneralConfigInstance(Context context, AbstractConfig abstractConfig) {
        GeneralConfigTool generalConfigTool = configToolContainer.get(abstractConfig.getConfigKey());
        if (generalConfigTool == null) {
            GeneralConfigTool generalConfigTool2 = new GeneralConfigTool(context, abstractConfig);
            configToolContainer.put(abstractConfig.getConfigKey(), generalConfigTool2);
            L.info("GeneralProxy", "new GeneralConfigTool && configKey:%s", abstractConfig.getConfigKey());
            return generalConfigTool2;
        }
        return generalConfigTool;
    }

    public static synchronized void startTimer(Context context, Long l) {
        synchronized (GeneralProxy.class) {
            initFlushManager(context);
            mFlushManager.startTimer(context, l);
        }
    }

    public static synchronized void flushCache(Context context) {
        synchronized (GeneralProxy.class) {
            flushCache(context, true);
        }
    }

    public static void initFlushManager(Context context) {
        if (mFlushManager == null) {
            synchronized (OBJ_KEY) {
                if (mFlushManager == null) {
                    FlushManager flushManager = new FlushManager();
                    mFlushManager = flushManager;
                    flushManager.setFlushListener(new FlushManager.FlushListener() { // from class: com.yy.hiidostatis.inner.GeneralProxy.1
                        @Override // com.yy.hiidostatis.inner.FlushManager.FlushListener
                        public void fluch(Context context2) {
                            GeneralProxy.flushCache(context2);
                        }
                    });
                    mFlushManager.regConnectionChangeReceiver(context);
                }
            }
        }
    }

    public static synchronized void start(Context context) {
        synchronized (GeneralProxy.class) {
            try {
                initFlushManager(context);
                flushCache(context);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static synchronized void stopTimer(Context context) {
        synchronized (GeneralProxy.class) {
            initFlushManager(context);
            mFlushManager.stopTimer(context);
        }
    }

    public static GeneralStatisTool getGeneralStatisInstance(Context context, AbstractConfig abstractConfig) {
        initFlushManager(context);
        GeneralStatisTool generalStatisTool = statisToolContainer.get(abstractConfig.getConfigKey());
        if (generalStatisTool == null) {
            GeneralStatisTool generalStatisTool2 = new GeneralStatisTool(context, abstractConfig);
            statisToolContainer.put(abstractConfig.getConfigKey(), generalStatisTool2);
            generalStatisTool2.getTaskManager().flush(context);
            L.info("GeneralProxy", "new GeneralStatisTool && configKey:%s", abstractConfig.getConfigKey());
            return generalStatisTool2;
        }
        return generalStatisTool;
    }
}
