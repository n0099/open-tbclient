package kotlin.reflect.jvm.internal.impl.types.checker;

import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import kotlin.jvm.internal.Reflection;
/* loaded from: classes9.dex */
public final class ClassicTypeCheckerContextKt {
    public static final String errorMessage(Object obj) {
        return "ClassicTypeCheckerContext couldn't handle " + Reflection.getOrCreateKotlinClass(obj.getClass()) + WebvttCueParser.CHAR_SPACE + obj;
    }
}
