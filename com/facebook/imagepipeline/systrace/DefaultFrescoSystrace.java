package com.facebook.imagepipeline.systrace;

import android.os.Build;
import android.os.Trace;
import com.baidu.android.common.others.lang.StringUtil;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
/* loaded from: classes7.dex */
public class DefaultFrescoSystrace implements FrescoSystrace.Systrace {
    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public void beginSection(String str) {
    }

    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public void endSection() {
    }

    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public boolean isTracing() {
        return false;
    }

    /* loaded from: classes7.dex */
    public static final class DefaultArgsBuilder implements FrescoSystrace.ArgsBuilder {
        public final StringBuilder mStringBuilder;

        public DefaultArgsBuilder(String str) {
            this.mStringBuilder = new StringBuilder(str);
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public FrescoSystrace.ArgsBuilder arg(String str, double d) {
            StringBuilder sb = this.mStringBuilder;
            sb.append(WebvttCueParser.CHAR_SEMI_COLON);
            sb.append(str);
            sb.append('=');
            sb.append(Double.toString(d));
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public FrescoSystrace.ArgsBuilder arg(String str, int i) {
            StringBuilder sb = this.mStringBuilder;
            sb.append(WebvttCueParser.CHAR_SEMI_COLON);
            sb.append(str);
            sb.append('=');
            sb.append(Integer.toString(i));
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public FrescoSystrace.ArgsBuilder arg(String str, long j) {
            StringBuilder sb = this.mStringBuilder;
            sb.append(WebvttCueParser.CHAR_SEMI_COLON);
            sb.append(str);
            sb.append('=');
            sb.append(Long.toString(j));
            return this;
        }

        @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder
        public FrescoSystrace.ArgsBuilder arg(String str, Object obj) {
            String obj2;
            StringBuilder sb = this.mStringBuilder;
            sb.append(WebvttCueParser.CHAR_SEMI_COLON);
            sb.append(str);
            sb.append('=');
            if (obj == null) {
                obj2 = StringUtil.NULL_STRING;
            } else {
                obj2 = obj.toString();
            }
            sb.append(obj2);
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
    }

    @Override // com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace
    public FrescoSystrace.ArgsBuilder beginSectionWithArgs(String str) {
        return FrescoSystrace.NO_OP_ARGS_BUILDER;
    }
}
