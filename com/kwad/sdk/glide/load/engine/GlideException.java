package com.kwad.sdk.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bumptech.glide.load.engine.GlideException;
import com.kwad.sdk.glide.load.DataSource;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public final class GlideException extends Exception {
    public static final StackTraceElement[] EMPTY_ELEMENTS = new StackTraceElement[0];
    public static final long serialVersionUID = 1;
    public final List<Throwable> causes;
    public Class<?> dataClass;
    public DataSource dataSource;
    public String detailMessage;
    @Nullable
    public Exception exception;
    public com.kwad.sdk.glide.load.c key;

    /* loaded from: classes7.dex */
    public static final class a implements Appendable {

        /* renamed from: a  reason: collision with root package name */
        public final Appendable f36185a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f36186b = true;

        public a(Appendable appendable) {
            this.f36185a = appendable;
        }

        @NonNull
        private CharSequence a(@Nullable CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c2) {
            if (this.f36186b) {
                this.f36186b = false;
                this.f36185a.append(GlideException.IndentedAppendable.INDENT);
            }
            this.f36186b = c2 == '\n';
            this.f36185a.append(c2);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(@Nullable CharSequence charSequence) {
            CharSequence a2 = a(charSequence);
            return append(a2, 0, a2.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(@Nullable CharSequence charSequence, int i2, int i3) {
            CharSequence a2 = a(charSequence);
            boolean z = false;
            if (this.f36186b) {
                this.f36186b = false;
                this.f36185a.append(GlideException.IndentedAppendable.INDENT);
            }
            if (a2.length() > 0 && a2.charAt(i3 - 1) == '\n') {
                z = true;
            }
            this.f36186b = z;
            this.f36185a.append(a2, i2, i3);
            return this;
        }
    }

    public GlideException(String str) {
        this(str, Collections.emptyList());
    }

    public GlideException(String str, Throwable th) {
        this(str, Collections.singletonList(th));
    }

    public GlideException(String str, List<Throwable> list) {
        this.detailMessage = str;
        setStackTrace(EMPTY_ELEMENTS);
        this.causes = list;
    }

    private void addRootCauses(Throwable th, List<Throwable> list) {
        if (!(th instanceof GlideException)) {
            list.add(th);
            return;
        }
        for (Throwable th2 : ((GlideException) th).getCauses()) {
            addRootCauses(th2, list);
        }
    }

    public static void appendCauses(List<Throwable> list, Appendable appendable) {
        try {
            appendCausesWrapped(list, appendable);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void appendCausesWrapped(List<Throwable> list, Appendable appendable) {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            appendable.append("Cause (").append(String.valueOf(i3)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i2);
            if (th instanceof GlideException) {
                ((GlideException) th).printStackTrace(appendable);
            } else {
                appendExceptionMessage(th, appendable);
            }
            i2 = i3;
        }
    }

    public static void appendExceptionMessage(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    private void printStackTrace(Appendable appendable) {
        appendExceptionMessage(this, appendable);
        appendCauses(getCauses(), new a(appendable));
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    public List<Throwable> getCauses() {
        return this.causes;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String str;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.detailMessage);
        sb.append(this.dataClass != null ? StringUtil.ARRAY_ELEMENT_SEPARATOR + this.dataClass : "");
        sb.append(this.dataSource != null ? StringUtil.ARRAY_ELEMENT_SEPARATOR + this.dataSource : "");
        sb.append(this.key != null ? StringUtil.ARRAY_ELEMENT_SEPARATOR + this.key : "");
        List<Throwable> rootCauses = getRootCauses();
        if (rootCauses.isEmpty()) {
            return sb.toString();
        }
        if (rootCauses.size() == 1) {
            str = "\nThere was 1 cause:";
        } else {
            sb.append("\nThere were ");
            sb.append(rootCauses.size());
            str = " causes:";
        }
        sb.append(str);
        for (Throwable th : rootCauses) {
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    @Nullable
    public Exception getOrigin() {
        return this.exception;
    }

    public List<Throwable> getRootCauses() {
        ArrayList arrayList = new ArrayList();
        addRootCauses(this, arrayList);
        return arrayList;
    }

    public void logRootCauses(String str) {
        List<Throwable> rootCauses = getRootCauses();
        int size = rootCauses.size();
        int i2 = 0;
        while (i2 < size) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i3 = i2 + 1;
            sb.append(i3);
            sb.append(" of ");
            sb.append(size);
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            Log.i(str, sb.toString(), rootCauses.get(i2));
            i2 = i3;
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        printStackTrace((Appendable) printStream);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        printStackTrace((Appendable) printWriter);
    }

    public void setLoggingDetails(com.kwad.sdk.glide.load.c cVar, DataSource dataSource) {
        setLoggingDetails(cVar, dataSource, null);
    }

    public void setLoggingDetails(com.kwad.sdk.glide.load.c cVar, DataSource dataSource, Class<?> cls) {
        this.key = cVar;
        this.dataSource = dataSource;
        this.dataClass = cls;
    }

    public void setOrigin(@Nullable Exception exc) {
        this.exception = exc;
    }
}
