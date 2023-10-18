package org.aspectj.runtime.internal;

import com.baidu.mobads.sdk.internal.cj;
import com.baidu.searchbox.player.model.YYOption;
import org.aspectj.runtime.internal.cflowstack.ThreadCounter;
import org.aspectj.runtime.internal.cflowstack.ThreadStackFactory;
import org.aspectj.runtime.internal.cflowstack.ThreadStackFactoryImpl;
import org.aspectj.runtime.internal.cflowstack.ThreadStackFactoryImpl11;
/* loaded from: classes2.dex */
public class CFlowCounter {
    public static ThreadStackFactory tsFactory;
    public ThreadCounter flowHeightHandler = tsFactory.getNewThreadCounter();

    static {
        selectFactoryForVMVersion();
    }

    public static ThreadStackFactory getThreadLocalStackFactory() {
        return new ThreadStackFactoryImpl();
    }

    public static ThreadStackFactory getThreadLocalStackFactoryFor11() {
        return new ThreadStackFactoryImpl11();
    }

    public static String getThreadStackFactoryClassName() {
        return tsFactory.getClass().getName();
    }

    public void dec() {
        this.flowHeightHandler.dec();
        if (!this.flowHeightHandler.isNotZero()) {
            this.flowHeightHandler.removeThreadCounter();
        }
    }

    public void inc() {
        this.flowHeightHandler.inc();
    }

    public boolean isValid() {
        return this.flowHeightHandler.isNotZero();
    }

    public static String getSystemPropertyWithoutSecurityException(String str, String str2) {
        try {
            return System.getProperty(str, str2);
        } catch (SecurityException unused) {
            return str2;
        }
    }

    public static void selectFactoryForVMVersion() {
        String systemPropertyWithoutSecurityException = getSystemPropertyWithoutSecurityException("aspectj.runtime.cflowstack.usethreadlocal", "unspecified");
        boolean z = false;
        if (!systemPropertyWithoutSecurityException.equals("unspecified") ? systemPropertyWithoutSecurityException.equals("yes") || systemPropertyWithoutSecurityException.equals(YYOption.IsLive.VALUE_TRUE) : System.getProperty("java.class.version", cj.d).compareTo("46.0") >= 0) {
            z = true;
        }
        if (z) {
            tsFactory = getThreadLocalStackFactory();
        } else {
            tsFactory = getThreadLocalStackFactoryFor11();
        }
    }
}
