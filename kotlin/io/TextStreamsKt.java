package kotlin.io;

import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteHelper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.text.Charsets;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\u0004\u001a\u00020\u0007*\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0004\u0010\b\u001a#\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a%\u0010\u0011\u001a\u00020\u000f*\u00020\u00002\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013*\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0011\u0010\u0018\u001a\u00020\u0017*\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001a*\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0011\u0010\u001d\u001a\u00020\u000e*\u00020\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001e\u0010\u001d\u001a\u00020\u000e*\u00020\u00162\b\b\u0002\u0010 \u001a\u00020\u001fH\u0087\b¢\u0006\u0004\b\u001d\u0010!\u001a\u0014\u0010#\u001a\u00020\"*\u00020\u000eH\u0087\b¢\u0006\u0004\b#\u0010$\u001a:\u0010(\u001a\u00028\u0000\"\u0004\b\u0000\u0010%*\u00020\u00002\u0018\u0010&\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0013\u0012\u0004\u0012\u00028\u00000\rH\u0086\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)\u0082\u0002\u000f\n\u0006\b\u0011('0\u0001\n\u0005\b\u009920\u0001¨\u0006*"}, d2 = {"Ljava/io/Reader;", "", "bufferSize", "Ljava/io/BufferedReader;", "buffered", "(Ljava/io/Reader;I)Ljava/io/BufferedReader;", "Ljava/io/Writer;", "Ljava/io/BufferedWriter;", "(Ljava/io/Writer;I)Ljava/io/BufferedWriter;", "out", "", "copyTo", "(Ljava/io/Reader;Ljava/io/Writer;I)J", "Lkotlin/Function1;", "", "", "action", "forEachLine", "(Ljava/io/Reader;Lkotlin/Function1;)V", "Lkotlin/sequences/Sequence;", "lineSequence", "(Ljava/io/BufferedReader;)Lkotlin/sequences/Sequence;", "Ljava/net/URL;", "", "readBytes", "(Ljava/net/URL;)[B", "", "readLines", "(Ljava/io/Reader;)Ljava/util/List;", "readText", "(Ljava/io/Reader;)Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", "(Ljava/net/URL;Ljava/nio/charset/Charset;)Ljava/lang/String;", "Ljava/io/StringReader;", "reader", "(Ljava/lang/String;)Ljava/io/StringReader;", "T", BreakpointSQLiteHelper.BLOCK_TABLE_NAME, "Requires newer compiler version to be inlined correctly.", "useLines", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "TextStreamsKt")
/* loaded from: classes3.dex */
public final class TextStreamsKt {
    @InlineOnly
    public static final BufferedReader buffered(Reader reader, int i2) {
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i2);
    }

    public static /* synthetic */ BufferedReader buffered$default(Reader reader, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i2);
    }

    public static final long copyTo(Reader copyTo, Writer out, int i2) {
        Intrinsics.checkNotNullParameter(copyTo, "$this$copyTo");
        Intrinsics.checkNotNullParameter(out, "out");
        char[] cArr = new char[i2];
        int read = copyTo.read(cArr);
        long j = 0;
        while (read >= 0) {
            out.write(cArr, 0, read);
            j += read;
            read = copyTo.read(cArr);
        }
        return j;
    }

    public static /* synthetic */ long copyTo$default(Reader reader, Writer writer, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        return copyTo(reader, writer, i2);
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static final void forEachLine(Reader forEachLine, Function1<? super String, Unit> action) {
        Intrinsics.checkNotNullParameter(forEachLine, "$this$forEachLine");
        Intrinsics.checkNotNullParameter(action, "action");
        BufferedReader bufferedReader = forEachLine instanceof BufferedReader ? (BufferedReader) forEachLine : new BufferedReader(forEachLine, 8192);
        try {
            for (String str : lineSequence(bufferedReader)) {
                action.invoke(str);
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedReader, null);
        } finally {
        }
    }

    public static final Sequence<String> lineSequence(BufferedReader lineSequence) {
        Intrinsics.checkNotNullParameter(lineSequence, "$this$lineSequence");
        return SequencesKt__SequencesKt.constrainOnce(new LinesSequence(lineSequence));
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static final byte[] readBytes(URL readBytes) {
        Intrinsics.checkNotNullParameter(readBytes, "$this$readBytes");
        InputStream it = readBytes.openStream();
        try {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            byte[] readBytes2 = ByteStreamsKt.readBytes(it);
            CloseableKt.closeFinally(it, null);
            return readBytes2;
        } finally {
        }
    }

    public static final List<String> readLines(Reader readLines) {
        Intrinsics.checkNotNullParameter(readLines, "$this$readLines");
        ArrayList arrayList = new ArrayList();
        forEachLine(readLines, new TextStreamsKt$readLines$1(arrayList));
        return arrayList;
    }

    public static final String readText(Reader readText) {
        Intrinsics.checkNotNullParameter(readText, "$this$readText");
        StringWriter stringWriter = new StringWriter();
        copyTo$default(readText, stringWriter, 0, 2, null);
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "buffer.toString()");
        return stringWriter2;
    }

    public static /* synthetic */ String readText$default(URL url, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return new String(readBytes(url), charset);
    }

    @InlineOnly
    public static final StringReader reader(String str) {
        return new StringReader(str);
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static final <T> T useLines(Reader useLines, Function1<? super Sequence<String>, ? extends T> block) {
        Intrinsics.checkNotNullParameter(useLines, "$this$useLines");
        Intrinsics.checkNotNullParameter(block, "block");
        BufferedReader bufferedReader = useLines instanceof BufferedReader ? (BufferedReader) useLines : new BufferedReader(useLines, 8192);
        try {
            T invoke = block.invoke(lineSequence(bufferedReader));
            InlineMarker.finallyStart(1);
            if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
                CloseableKt.closeFinally(bufferedReader, null);
            } else {
                bufferedReader.close();
            }
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
                    CloseableKt.closeFinally(bufferedReader, th);
                } else {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused) {
                    }
                }
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
    }

    @InlineOnly
    public static final BufferedWriter buffered(Writer writer, int i2) {
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i2);
    }

    public static /* synthetic */ BufferedWriter buffered$default(Writer writer, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i2);
    }

    @InlineOnly
    public static final String readText(URL url, Charset charset) {
        return new String(readBytes(url), charset);
    }
}
