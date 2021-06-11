package d.a.c.j;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.titan.TitanDownloadService;
import java.lang.Thread;
/* loaded from: classes.dex */
public class c implements Thread.UncaughtExceptionHandler {

    /* renamed from: e  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f42854e;

    public c(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f42854e = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        TitanDownloadService.startServiceIfNeeded(BdBaseApplication.getInst().getContext());
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f42854e;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
