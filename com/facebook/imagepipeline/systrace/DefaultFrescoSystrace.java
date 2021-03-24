package com.facebook.imagepipeline.systrace;

import android.os.Build;
import android.os.Trace;
import com.alipay.sdk.encrypt.a;
import com.baidu.android.common.others.lang.StringUtil;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
/* loaded from: classes6.dex */
public class DefaultFrescoSystrace implements FrescoSystrace.Systrace {
    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public void beginSection(String str) {
    }

    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public FrescoSystrace.ArgsBuilder beginSectionWithArgs(String str) {
        return FrescoSystrace.NO_OP_ARGS_BUILDER;
    }

    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public void endSection() {
    }

    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public boolean isTracing() {
        return false;
    }

    /* loaded from: classes6.dex */
    public static final class DefaultArgsBuilder implements FrescoSystrace.ArgsBuilder {
        public final StringBuilder mStringBuilder;

        public DefaultArgsBuilder(String str) {
            this.mStringBuilder = new StringBuilder(str);
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public FrescoSystrace.ArgsBuilder arg(String str, Object obj) {
            StringBuilder sb = this.mStringBuilder;
            sb.append(';');
            sb.append(str);
            sb.append(a.f1897h);
            sb.append(obj == null ? StringUtil.NULL_STRING : obj.toString());
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public void flush() {
            if (this.mStringBuilder.length() > 127) {
                this.mStringBuilder.setLength(127);
            }
            if (Build.VERSION.SDK_INT >= 18) {
                Trace.beginSection(this.mStringBuilder.toString());
            }
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public FrescoSystrace.ArgsBuilder arg(String str, int i) {
            StringBuilder sb = this.mStringBuilder;
            sb.append(';');
            sb.append(str);
            sb.append(a.f1897h);
            sb.append(Integer.toString(i));
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public FrescoSystrace.ArgsBuilder arg(String str, long j) {
            StringBuilder sb = this.mStringBuilder;
            sb.append(';');
            sb.append(str);
            sb.append(a.f1897h);
            sb.append(Long.toString(j));
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public FrescoSystrace.ArgsBuilder arg(String str, double d2) {
            StringBuilder sb = this.mStringBuilder;
            sb.append(';');
            sb.append(str);
            sb.append(a.f1897h);
            sb.append(Double.toString(d2));
            return this;
        }
    }
}
