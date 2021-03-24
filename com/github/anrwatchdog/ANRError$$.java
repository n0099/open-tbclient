package com.github.anrwatchdog;

import com.github.anrwatchdog.ANRError;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class ANRError$$ implements Serializable {
    public final String _name;
    public final StackTraceElement[] _stackTrace;

    /* loaded from: classes6.dex */
    public class _Thread extends Throwable {
        public /* synthetic */ _Thread(ANRError$$ aNRError$$, _Thread _thread, ANRError.a aVar) {
            this(_thread);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            setStackTrace(ANRError$$.this._stackTrace);
            return this;
        }

        public _Thread(_Thread _thread) {
            super(ANRError$$.this._name, _thread);
        }
    }

    public /* synthetic */ ANRError$$(String str, StackTraceElement[] stackTraceElementArr, ANRError.a aVar) {
        this(str, stackTraceElementArr);
    }

    public ANRError$$(String str, StackTraceElement[] stackTraceElementArr) {
        this._name = str;
        this._stackTrace = stackTraceElementArr;
    }
}
