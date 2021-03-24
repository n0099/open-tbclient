package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0019\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0013\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0017\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\bW\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\b\u001b\n\u0002\u0010\u000f\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0015\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002*\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\t0\u0002*\u00020\b¢\u0006\u0004\b\u0003\u0010\n\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\f0\u0002*\u00020\u000b¢\u0006\u0004\b\u0003\u0010\r\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0002*\u00020\u000e¢\u0006\u0004\b\u0003\u0010\u0010\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00120\u0002*\u00020\u0011¢\u0006\u0004\b\u0003\u0010\u0013\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00150\u0002*\u00020\u0014¢\u0006\u0004\b\u0003\u0010\u0016\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00180\u0002*\u00020\u0017¢\u0006\u0004\b\u0003\u0010\u0019\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0002*\u00020\u001a¢\u0006\u0004\b\u0003\u0010\u001c\u001aW\u0010#\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010\u001d\u001a\u00028\u00002\u001a\u0010 \u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u001ej\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u001f2\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0004\b#\u0010$\u001a;\u0010#\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0006\u0010\u001d\u001a\u00028\u00002\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0004\b#\u0010%\u001a-\u0010#\u001a\u00020\u0015*\u00020\b2\u0006\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0004\b#\u0010&\u001a-\u0010#\u001a\u00020\u0015*\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0004\b#\u0010'\u001a-\u0010#\u001a\u00020\u0015*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0004\b#\u0010(\u001a-\u0010#\u001a\u00020\u0015*\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0004\b#\u0010)\u001a-\u0010#\u001a\u00020\u0015*\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00152\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0004\b#\u0010*\u001a-\u0010#\u001a\u00020\u0015*\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0004\b#\u0010+\u001a-\u0010#\u001a\u00020\u0015*\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0004\b#\u0010,\u001a2\u00100\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u000e\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0087\f¢\u0006\u0004\b.\u0010/\u001a\"\u00103\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0087\b¢\u0006\u0004\b1\u00102\u001a\"\u00107\u001a\u000204\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0087\b¢\u0006\u0004\b5\u00106\u001a2\u00108\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u000e\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0087\f¢\u0006\u0004\b8\u0010/\u001a\u001c\u00108\u001a\u00020\u0006*\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0087\f¢\u0006\u0004\b8\u00109\u001a\u001c\u00108\u001a\u00020\u0006*\u00020\b2\u0006\u0010-\u001a\u00020\bH\u0087\f¢\u0006\u0004\b8\u0010:\u001a\u001c\u00108\u001a\u00020\u0006*\u00020\u000b2\u0006\u0010-\u001a\u00020\u000bH\u0087\f¢\u0006\u0004\b8\u0010;\u001a\u001c\u00108\u001a\u00020\u0006*\u00020\u000e2\u0006\u0010-\u001a\u00020\u000eH\u0087\f¢\u0006\u0004\b8\u0010<\u001a\u001c\u00108\u001a\u00020\u0006*\u00020\u00112\u0006\u0010-\u001a\u00020\u0011H\u0087\f¢\u0006\u0004\b8\u0010=\u001a\u001c\u00108\u001a\u00020\u0006*\u00020\u00142\u0006\u0010-\u001a\u00020\u0014H\u0087\f¢\u0006\u0004\b8\u0010>\u001a\u001c\u00108\u001a\u00020\u0006*\u00020\u00172\u0006\u0010-\u001a\u00020\u0017H\u0087\f¢\u0006\u0004\b8\u0010?\u001a\u001c\u00108\u001a\u00020\u0006*\u00020\u001a2\u0006\u0010-\u001a\u00020\u001aH\u0087\f¢\u0006\u0004\b8\u0010@\u001a\"\u0010A\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0087\b¢\u0006\u0004\bA\u00102\u001a\u0014\u0010A\u001a\u00020\u0015*\u00020\u0005H\u0087\b¢\u0006\u0004\bA\u0010B\u001a\u0014\u0010A\u001a\u00020\u0015*\u00020\bH\u0087\b¢\u0006\u0004\bA\u0010C\u001a\u0014\u0010A\u001a\u00020\u0015*\u00020\u000bH\u0087\b¢\u0006\u0004\bA\u0010D\u001a\u0014\u0010A\u001a\u00020\u0015*\u00020\u000eH\u0087\b¢\u0006\u0004\bA\u0010E\u001a\u0014\u0010A\u001a\u00020\u0015*\u00020\u0011H\u0087\b¢\u0006\u0004\bA\u0010F\u001a\u0014\u0010A\u001a\u00020\u0015*\u00020\u0014H\u0087\b¢\u0006\u0004\bA\u0010G\u001a\u0014\u0010A\u001a\u00020\u0015*\u00020\u0017H\u0087\b¢\u0006\u0004\bA\u0010H\u001a\u0014\u0010A\u001a\u00020\u0015*\u00020\u001aH\u0087\b¢\u0006\u0004\bA\u0010I\u001a\"\u0010J\u001a\u000204\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0087\b¢\u0006\u0004\bJ\u00106\u001a\u0014\u0010J\u001a\u000204*\u00020\u0005H\u0087\b¢\u0006\u0004\bJ\u0010K\u001a\u0014\u0010J\u001a\u000204*\u00020\bH\u0087\b¢\u0006\u0004\bJ\u0010L\u001a\u0014\u0010J\u001a\u000204*\u00020\u000bH\u0087\b¢\u0006\u0004\bJ\u0010M\u001a\u0014\u0010J\u001a\u000204*\u00020\u000eH\u0087\b¢\u0006\u0004\bJ\u0010N\u001a\u0014\u0010J\u001a\u000204*\u00020\u0011H\u0087\b¢\u0006\u0004\bJ\u0010O\u001a\u0014\u0010J\u001a\u000204*\u00020\u0014H\u0087\b¢\u0006\u0004\bJ\u0010P\u001a\u0014\u0010J\u001a\u000204*\u00020\u0017H\u0087\b¢\u0006\u0004\bJ\u0010Q\u001a\u0014\u0010J\u001a\u000204*\u00020\u001aH\u0087\b¢\u0006\u0004\bJ\u0010R\u001aS\u0010W\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\f\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010T\u001a\u00020\u00152\b\b\u0002\u0010U\u001a\u00020\u00152\b\b\u0002\u0010V\u001a\u00020\u0015H\u0007¢\u0006\u0004\bW\u0010X\u001a9\u0010W\u001a\u00020\u0005*\u00020\u00052\u0006\u0010S\u001a\u00020\u00052\b\b\u0002\u0010T\u001a\u00020\u00152\b\b\u0002\u0010U\u001a\u00020\u00152\b\b\u0002\u0010V\u001a\u00020\u0015H\u0007¢\u0006\u0004\bW\u0010Y\u001a9\u0010W\u001a\u00020\b*\u00020\b2\u0006\u0010S\u001a\u00020\b2\b\b\u0002\u0010T\u001a\u00020\u00152\b\b\u0002\u0010U\u001a\u00020\u00152\b\b\u0002\u0010V\u001a\u00020\u0015H\u0007¢\u0006\u0004\bW\u0010Z\u001a9\u0010W\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010S\u001a\u00020\u000b2\b\b\u0002\u0010T\u001a\u00020\u00152\b\b\u0002\u0010U\u001a\u00020\u00152\b\b\u0002\u0010V\u001a\u00020\u0015H\u0007¢\u0006\u0004\bW\u0010[\u001a9\u0010W\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010S\u001a\u00020\u000e2\b\b\u0002\u0010T\u001a\u00020\u00152\b\b\u0002\u0010U\u001a\u00020\u00152\b\b\u0002\u0010V\u001a\u00020\u0015H\u0007¢\u0006\u0004\bW\u0010\\\u001a9\u0010W\u001a\u00020\u0011*\u00020\u00112\u0006\u0010S\u001a\u00020\u00112\b\b\u0002\u0010T\u001a\u00020\u00152\b\b\u0002\u0010U\u001a\u00020\u00152\b\b\u0002\u0010V\u001a\u00020\u0015H\u0007¢\u0006\u0004\bW\u0010]\u001a9\u0010W\u001a\u00020\u0014*\u00020\u00142\u0006\u0010S\u001a\u00020\u00142\b\b\u0002\u0010T\u001a\u00020\u00152\b\b\u0002\u0010U\u001a\u00020\u00152\b\b\u0002\u0010V\u001a\u00020\u0015H\u0007¢\u0006\u0004\bW\u0010^\u001a9\u0010W\u001a\u00020\u0017*\u00020\u00172\u0006\u0010S\u001a\u00020\u00172\b\b\u0002\u0010T\u001a\u00020\u00152\b\b\u0002\u0010U\u001a\u00020\u00152\b\b\u0002\u0010V\u001a\u00020\u0015H\u0007¢\u0006\u0004\bW\u0010_\u001a9\u0010W\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010S\u001a\u00020\u001a2\b\b\u0002\u0010T\u001a\u00020\u00152\b\b\u0002\u0010U\u001a\u00020\u00152\b\b\u0002\u0010V\u001a\u00020\u0015H\u0007¢\u0006\u0004\bW\u0010`\u001a&\u0010a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087\b¢\u0006\u0004\ba\u0010b\u001a0\u0010a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010c\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\ba\u0010d\u001a\u0014\u0010a\u001a\u00020\u0005*\u00020\u0005H\u0087\b¢\u0006\u0004\ba\u0010e\u001a\u001c\u0010a\u001a\u00020\u0005*\u00020\u00052\u0006\u0010c\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\ba\u0010f\u001a\u0014\u0010a\u001a\u00020\b*\u00020\bH\u0087\b¢\u0006\u0004\ba\u0010g\u001a\u001c\u0010a\u001a\u00020\b*\u00020\b2\u0006\u0010c\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\ba\u0010h\u001a\u0014\u0010a\u001a\u00020\u000b*\u00020\u000bH\u0087\b¢\u0006\u0004\ba\u0010i\u001a\u001c\u0010a\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010c\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\ba\u0010j\u001a\u0014\u0010a\u001a\u00020\u000e*\u00020\u000eH\u0087\b¢\u0006\u0004\ba\u0010k\u001a\u001c\u0010a\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010c\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\ba\u0010l\u001a\u0014\u0010a\u001a\u00020\u0011*\u00020\u0011H\u0087\b¢\u0006\u0004\ba\u0010m\u001a\u001c\u0010a\u001a\u00020\u0011*\u00020\u00112\u0006\u0010c\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\ba\u0010n\u001a\u0014\u0010a\u001a\u00020\u0014*\u00020\u0014H\u0087\b¢\u0006\u0004\ba\u0010o\u001a\u001c\u0010a\u001a\u00020\u0014*\u00020\u00142\u0006\u0010c\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\ba\u0010p\u001a\u0014\u0010a\u001a\u00020\u0017*\u00020\u0017H\u0087\b¢\u0006\u0004\ba\u0010q\u001a\u001c\u0010a\u001a\u00020\u0017*\u00020\u00172\u0006\u0010c\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\ba\u0010r\u001a\u0014\u0010a\u001a\u00020\u001a*\u00020\u001aH\u0087\b¢\u0006\u0004\ba\u0010s\u001a\u001c\u0010a\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010c\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\ba\u0010t\u001a6\u0010w\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\bu\u0010v\u001a$\u0010w\u001a\u00020\u0005*\u00020\u00052\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\bu\u0010x\u001a$\u0010w\u001a\u00020\b*\u00020\b2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\bu\u0010y\u001a$\u0010w\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\bu\u0010z\u001a$\u0010w\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\bu\u0010{\u001a$\u0010w\u001a\u00020\u0011*\u00020\u00112\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\bu\u0010|\u001a$\u0010w\u001a\u00020\u0014*\u00020\u00142\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\bu\u0010}\u001a$\u0010w\u001a\u00020\u0017*\u00020\u00172\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\bu\u0010~\u001a$\u0010w\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\bu\u0010\u007f\u001a6\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0001¢\u0006\u0004\bw\u0010v\u001a$\u0010\u0080\u0001\u001a\u00020\u0005*\u00020\u00052\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0001¢\u0006\u0004\bw\u0010x\u001a$\u0010\u0080\u0001\u001a\u00020\b*\u00020\b2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0001¢\u0006\u0004\bw\u0010y\u001a$\u0010\u0080\u0001\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0001¢\u0006\u0004\bw\u0010z\u001a$\u0010\u0080\u0001\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0001¢\u0006\u0004\bw\u0010{\u001a$\u0010\u0080\u0001\u001a\u00020\u0011*\u00020\u00112\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0001¢\u0006\u0004\bw\u0010|\u001a$\u0010\u0080\u0001\u001a\u00020\u0014*\u00020\u00142\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0001¢\u0006\u0004\bw\u0010}\u001a$\u0010\u0080\u0001\u001a\u00020\u0017*\u00020\u00172\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0001¢\u0006\u0004\bw\u0010~\u001a$\u0010\u0080\u0001\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0001¢\u0006\u0004\bw\u0010\u007f\u001a.\u0010\u0082\u0001\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u0007\u0010\u0081\u0001\u001a\u00020\u0015H\u0087\b¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a \u0010\u0082\u0001\u001a\u00020\u0006*\u00020\u00052\u0007\u0010\u0081\u0001\u001a\u00020\u0015H\u0087\b¢\u0006\u0006\b\u0082\u0001\u0010\u0084\u0001\u001a \u0010\u0082\u0001\u001a\u00020\t*\u00020\b2\u0007\u0010\u0081\u0001\u001a\u00020\u0015H\u0087\b¢\u0006\u0006\b\u0082\u0001\u0010\u0085\u0001\u001a \u0010\u0082\u0001\u001a\u00020\f*\u00020\u000b2\u0007\u0010\u0081\u0001\u001a\u00020\u0015H\u0087\b¢\u0006\u0006\b\u0082\u0001\u0010\u0086\u0001\u001a \u0010\u0082\u0001\u001a\u00020\u000f*\u00020\u000e2\u0007\u0010\u0081\u0001\u001a\u00020\u0015H\u0087\b¢\u0006\u0006\b\u0082\u0001\u0010\u0087\u0001\u001a \u0010\u0082\u0001\u001a\u00020\u0012*\u00020\u00112\u0007\u0010\u0081\u0001\u001a\u00020\u0015H\u0087\b¢\u0006\u0006\b\u0082\u0001\u0010\u0088\u0001\u001a \u0010\u0082\u0001\u001a\u00020\u0015*\u00020\u00142\u0007\u0010\u0081\u0001\u001a\u00020\u0015H\u0087\b¢\u0006\u0006\b\u0082\u0001\u0010\u0089\u0001\u001a \u0010\u0082\u0001\u001a\u00020\u0018*\u00020\u00172\u0007\u0010\u0081\u0001\u001a\u00020\u0015H\u0087\b¢\u0006\u0006\b\u0082\u0001\u0010\u008a\u0001\u001a \u0010\u0082\u0001\u001a\u00020\u001b*\u00020\u001a2\u0007\u0010\u0081\u0001\u001a\u00020\u0015H\u0087\b¢\u0006\u0006\b\u0082\u0001\u0010\u008b\u0001\u001a=\u0010\u008d\u0001\u001a\u00030\u008c\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001d\u001a\u00028\u00002\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a1\u0010\u008d\u0001\u001a\u00030\u008c\u0001*\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0006\b\u008d\u0001\u0010\u008f\u0001\u001a1\u0010\u008d\u0001\u001a\u00030\u008c\u0001*\u00020\b2\u0006\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0006\b\u008d\u0001\u0010\u0090\u0001\u001a1\u0010\u008d\u0001\u001a\u00030\u008c\u0001*\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0006\b\u008d\u0001\u0010\u0091\u0001\u001a1\u0010\u008d\u0001\u001a\u00030\u008c\u0001*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0006\b\u008d\u0001\u0010\u0092\u0001\u001a1\u0010\u008d\u0001\u001a\u00030\u008c\u0001*\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0006\b\u008d\u0001\u0010\u0093\u0001\u001a1\u0010\u008d\u0001\u001a\u00030\u008c\u0001*\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00152\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0006\b\u008d\u0001\u0010\u0094\u0001\u001a1\u0010\u008d\u0001\u001a\u00030\u008c\u0001*\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0006\b\u008d\u0001\u0010\u0095\u0001\u001a1\u0010\u008d\u0001\u001a\u00030\u008c\u0001*\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0006\b\u008d\u0001\u0010\u0096\u0001\u001a5\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0005\b\u0000\u0010\u0097\u0001*\u0006\u0012\u0002\b\u00030\u00012\u000e\u0010\u0099\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0098\u0001¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001\u001aK\u0010\u009e\u0001\u001a\u00028\u0000\"\u0012\b\u0000\u0010\u009d\u0001*\u000b\u0012\u0006\b\u0000\u0012\u00028\u00010\u009c\u0001\"\u0005\b\u0001\u0010\u0097\u0001*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010S\u001a\u00028\u00002\u000e\u0010\u0099\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u0098\u0001¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001\u001a1\u0010 \u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001d\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0006\b \u0001\u0010¡\u0001\u001a:\u0010 \u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000f\u0010¢\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0006\b \u0001\u0010£\u0001\u001a9\u0010 \u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010¢\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000¤\u0001H\u0086\u0002¢\u0006\u0006\b \u0001\u0010¥\u0001\u001a\u001f\u0010 \u0001\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0006H\u0086\u0002¢\u0006\u0006\b \u0001\u0010¦\u0001\u001a \u0010 \u0001\u001a\u00020\u0005*\u00020\u00052\u0007\u0010¢\u0001\u001a\u00020\u0005H\u0086\u0002¢\u0006\u0006\b \u0001\u0010§\u0001\u001a'\u0010 \u0001\u001a\u00020\u0005*\u00020\u00052\u000e\u0010¢\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060¤\u0001H\u0086\u0002¢\u0006\u0006\b \u0001\u0010¨\u0001\u001a\u001f\u0010 \u0001\u001a\u00020\b*\u00020\b2\u0006\u0010\u001d\u001a\u00020\tH\u0086\u0002¢\u0006\u0006\b \u0001\u0010©\u0001\u001a \u0010 \u0001\u001a\u00020\b*\u00020\b2\u0007\u0010¢\u0001\u001a\u00020\bH\u0086\u0002¢\u0006\u0006\b \u0001\u0010ª\u0001\u001a'\u0010 \u0001\u001a\u00020\b*\u00020\b2\u000e\u0010¢\u0001\u001a\t\u0012\u0004\u0012\u00020\t0¤\u0001H\u0086\u0002¢\u0006\u0006\b \u0001\u0010«\u0001\u001a\u001f\u0010 \u0001\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\fH\u0086\u0002¢\u0006\u0006\b \u0001\u0010¬\u0001\u001a \u0010 \u0001\u001a\u00020\u000b*\u00020\u000b2\u0007\u0010¢\u0001\u001a\u00020\u000bH\u0086\u0002¢\u0006\u0006\b \u0001\u0010\u00ad\u0001\u001a'\u0010 \u0001\u001a\u00020\u000b*\u00020\u000b2\u000e\u0010¢\u0001\u001a\t\u0012\u0004\u0012\u00020\f0¤\u0001H\u0086\u0002¢\u0006\u0006\b \u0001\u0010®\u0001\u001a\u001f\u0010 \u0001\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000fH\u0086\u0002¢\u0006\u0006\b \u0001\u0010¯\u0001\u001a \u0010 \u0001\u001a\u00020\u000e*\u00020\u000e2\u0007\u0010¢\u0001\u001a\u00020\u000eH\u0086\u0002¢\u0006\u0006\b \u0001\u0010°\u0001\u001a'\u0010 \u0001\u001a\u00020\u000e*\u00020\u000e2\u000e\u0010¢\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0¤\u0001H\u0086\u0002¢\u0006\u0006\b \u0001\u0010±\u0001\u001a\u001f\u0010 \u0001\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0012H\u0086\u0002¢\u0006\u0006\b \u0001\u0010²\u0001\u001a \u0010 \u0001\u001a\u00020\u0011*\u00020\u00112\u0007\u0010¢\u0001\u001a\u00020\u0011H\u0086\u0002¢\u0006\u0006\b \u0001\u0010³\u0001\u001a'\u0010 \u0001\u001a\u00020\u0011*\u00020\u00112\u000e\u0010¢\u0001\u001a\t\u0012\u0004\u0012\u00020\u00120¤\u0001H\u0086\u0002¢\u0006\u0006\b \u0001\u0010´\u0001\u001a\u001e\u0010 \u0001\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0015H\u0086\u0002¢\u0006\u0005\b \u0001\u0010p\u001a \u0010 \u0001\u001a\u00020\u0014*\u00020\u00142\u0007\u0010¢\u0001\u001a\u00020\u0014H\u0086\u0002¢\u0006\u0006\b \u0001\u0010µ\u0001\u001a'\u0010 \u0001\u001a\u00020\u0014*\u00020\u00142\u000e\u0010¢\u0001\u001a\t\u0012\u0004\u0012\u00020\u00150¤\u0001H\u0086\u0002¢\u0006\u0006\b \u0001\u0010¶\u0001\u001a\u001f\u0010 \u0001\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0018H\u0086\u0002¢\u0006\u0006\b \u0001\u0010·\u0001\u001a \u0010 \u0001\u001a\u00020\u0017*\u00020\u00172\u0007\u0010¢\u0001\u001a\u00020\u0017H\u0086\u0002¢\u0006\u0006\b \u0001\u0010¸\u0001\u001a'\u0010 \u0001\u001a\u00020\u0017*\u00020\u00172\u000e\u0010¢\u0001\u001a\t\u0012\u0004\u0012\u00020\u00180¤\u0001H\u0086\u0002¢\u0006\u0006\b \u0001\u0010¹\u0001\u001a\u001f\u0010 \u0001\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001bH\u0086\u0002¢\u0006\u0006\b \u0001\u0010º\u0001\u001a \u0010 \u0001\u001a\u00020\u001a*\u00020\u001a2\u0007\u0010¢\u0001\u001a\u00020\u001aH\u0086\u0002¢\u0006\u0006\b \u0001\u0010»\u0001\u001a'\u0010 \u0001\u001a\u00020\u001a*\u00020\u001a2\u000e\u0010¢\u0001\u001a\t\u0012\u0004\u0012\u00020\u001b0¤\u0001H\u0086\u0002¢\u0006\u0006\b \u0001\u0010¼\u0001\u001a1\u0010½\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u001d\u001a\u00028\u0000H\u0087\b¢\u0006\u0006\b½\u0001\u0010¡\u0001\u001a#\u0010¾\u0001\u001a\u00030\u008c\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0006\b¾\u0001\u0010¿\u0001\u001a1\u0010¾\u0001\u001a\u00030\u008c\u0001\"\u000f\b\u0000\u0010\u0000*\t\u0012\u0004\u0012\u00028\u00000À\u0001*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0087\b¢\u0006\u0006\b¾\u0001\u0010Á\u0001\u001a7\u0010¾\u0001\u001a\u00030\u008c\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0006\b¾\u0001\u0010Â\u0001\u001a\u0015\u0010¾\u0001\u001a\u00030\u008c\u0001*\u00020\b¢\u0006\u0006\b¾\u0001\u0010Ã\u0001\u001a)\u0010¾\u0001\u001a\u00030\u008c\u0001*\u00020\b2\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0006\b¾\u0001\u0010Ä\u0001\u001a\u0015\u0010¾\u0001\u001a\u00030\u008c\u0001*\u00020\u000b¢\u0006\u0006\b¾\u0001\u0010Å\u0001\u001a)\u0010¾\u0001\u001a\u00030\u008c\u0001*\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0006\b¾\u0001\u0010Æ\u0001\u001a\u0015\u0010¾\u0001\u001a\u00030\u008c\u0001*\u00020\u000e¢\u0006\u0006\b¾\u0001\u0010Ç\u0001\u001a)\u0010¾\u0001\u001a\u00030\u008c\u0001*\u00020\u000e2\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0006\b¾\u0001\u0010È\u0001\u001a\u0015\u0010¾\u0001\u001a\u00030\u008c\u0001*\u00020\u0011¢\u0006\u0006\b¾\u0001\u0010É\u0001\u001a)\u0010¾\u0001\u001a\u00030\u008c\u0001*\u00020\u00112\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0006\b¾\u0001\u0010Ê\u0001\u001a\u0015\u0010¾\u0001\u001a\u00030\u008c\u0001*\u00020\u0014¢\u0006\u0006\b¾\u0001\u0010Ë\u0001\u001a)\u0010¾\u0001\u001a\u00030\u008c\u0001*\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0006\b¾\u0001\u0010Ì\u0001\u001a\u0015\u0010¾\u0001\u001a\u00030\u008c\u0001*\u00020\u0017¢\u0006\u0006\b¾\u0001\u0010Í\u0001\u001a)\u0010¾\u0001\u001a\u00030\u008c\u0001*\u00020\u00172\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0006\b¾\u0001\u0010Î\u0001\u001a\u0015\u0010¾\u0001\u001a\u00030\u008c\u0001*\u00020\u001a¢\u0006\u0006\b¾\u0001\u0010Ï\u0001\u001a)\u0010¾\u0001\u001a\u00030\u008c\u0001*\u00020\u001a2\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0006\b¾\u0001\u0010Ð\u0001\u001a?\u0010Ñ\u0001\u001a\u00030\u008c\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u0010 \u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u001ej\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u001f¢\u0006\u0006\bÑ\u0001\u0010Ò\u0001\u001aS\u0010Ñ\u0001\u001a\u00030\u008c\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u0010 \u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u001ej\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u001f2\b\b\u0002\u0010!\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u0015¢\u0006\u0006\bÑ\u0001\u0010Ó\u0001\u001a4\u0010Õ\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000Ô\u0001\"\u000f\b\u0000\u0010\u0000*\t\u0012\u0004\u0012\u00028\u00000À\u0001*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001¢\u0006\u0006\bÕ\u0001\u0010Ö\u0001\u001aE\u0010Õ\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000Ô\u0001\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\u001a\u0010 \u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u001ej\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u001f¢\u0006\u0006\bÕ\u0001\u0010×\u0001\u001a\u001b\u0010Õ\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060Ô\u0001*\u00020\u0005¢\u0006\u0006\bÕ\u0001\u0010Ø\u0001\u001a\u001b\u0010Õ\u0001\u001a\t\u0012\u0004\u0012\u00020\t0Ô\u0001*\u00020\b¢\u0006\u0006\bÕ\u0001\u0010Ù\u0001\u001a\u001b\u0010Õ\u0001\u001a\t\u0012\u0004\u0012\u00020\f0Ô\u0001*\u00020\u000b¢\u0006\u0006\bÕ\u0001\u0010Ú\u0001\u001a\u001b\u0010Õ\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0Ô\u0001*\u00020\u000e¢\u0006\u0006\bÕ\u0001\u0010Û\u0001\u001a\u001b\u0010Õ\u0001\u001a\t\u0012\u0004\u0012\u00020\u00120Ô\u0001*\u00020\u0011¢\u0006\u0006\bÕ\u0001\u0010Ü\u0001\u001a\u001b\u0010Õ\u0001\u001a\t\u0012\u0004\u0012\u00020\u00150Ô\u0001*\u00020\u0014¢\u0006\u0006\bÕ\u0001\u0010Ý\u0001\u001a\u001b\u0010Õ\u0001\u001a\t\u0012\u0004\u0012\u00020\u00180Ô\u0001*\u00020\u0017¢\u0006\u0006\bÕ\u0001\u0010Þ\u0001\u001a\u001b\u0010Õ\u0001\u001a\t\u0012\u0004\u0012\u00020\u001b0Ô\u0001*\u00020\u001a¢\u0006\u0006\bÕ\u0001\u0010ß\u0001\u001a\u001a\u0010à\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0005¢\u0006\u0006\bà\u0001\u0010á\u0001\u001a\u001a\u0010à\u0001\u001a\b\u0012\u0004\u0012\u00020\t0\u0001*\u00020\b¢\u0006\u0006\bà\u0001\u0010â\u0001\u001a\u001a\u0010à\u0001\u001a\b\u0012\u0004\u0012\u00020\f0\u0001*\u00020\u000b¢\u0006\u0006\bà\u0001\u0010ã\u0001\u001a\u001a\u0010à\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001*\u00020\u000e¢\u0006\u0006\bà\u0001\u0010ä\u0001\u001a\u001a\u0010à\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001*\u00020\u0011¢\u0006\u0006\bà\u0001\u0010å\u0001\u001a\u001a\u0010à\u0001\u001a\b\u0012\u0004\u0012\u00020\u00150\u0001*\u00020\u0014¢\u0006\u0006\bà\u0001\u0010æ\u0001\u001a\u001a\u0010à\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180\u0001*\u00020\u0017¢\u0006\u0006\bà\u0001\u0010ç\u0001\u001a\u001a\u0010à\u0001\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0001*\u00020\u001a¢\u0006\u0006\bà\u0001\u0010è\u0001¨\u0006é\u0001"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "", "asList", "([Ljava/lang/Object;)Ljava/util/List;", "", "", "([Z)Ljava/util/List;", "", "", "([B)Ljava/util/List;", "", "", "([C)Ljava/util/List;", "", "", "([D)Ljava/util/List;", "", "", "([F)Ljava/util/List;", "", "", "([I)Ljava/util/List;", "", "", "([J)Ljava/util/List;", "", "", "([S)Ljava/util/List;", "element", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "fromIndex", "toIndex", "binarySearch", "([Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;II)I", "([Ljava/lang/Object;Ljava/lang/Object;II)I", "([BBII)I", "([CCII)I", "([DDII)I", "([FFII)I", "([IIII)I", "([JJII)I", "([SSII)I", "other", "contentDeepEqualsInline", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepEquals", "contentDeepHashCodeInline", "([Ljava/lang/Object;)I", "contentDeepHashCode", "", "contentDeepToStringInline", "([Ljava/lang/Object;)Ljava/lang/String;", "contentDeepToString", "contentEquals", "([Z[Z)Z", "([B[B)Z", "([C[C)Z", "([D[D)Z", "([F[F)Z", "([I[I)Z", "([J[J)Z", "([S[S)Z", "contentHashCode", "([Z)I", "([B)I", "([C)I", "([D)I", "([F)I", "([I)I", "([J)I", "([S)I", "contentToString", "([Z)Ljava/lang/String;", "([B)Ljava/lang/String;", "([C)Ljava/lang/String;", "([D)Ljava/lang/String;", "([F)Ljava/lang/String;", "([I)Ljava/lang/String;", "([J)Ljava/lang/String;", "([S)Ljava/lang/String;", "destination", "destinationOffset", "startIndex", "endIndex", "copyInto", "([Ljava/lang/Object;[Ljava/lang/Object;III)[Ljava/lang/Object;", "([Z[ZIII)[Z", "([B[BIII)[B", "([C[CIII)[C", "([D[DIII)[D", "([F[FIII)[F", "([I[IIII)[I", "([J[JIII)[J", "([S[SIII)[S", "copyOf", "([Ljava/lang/Object;)[Ljava/lang/Object;", "newSize", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "([Z)[Z", "([ZI)[Z", "([B)[B", "([BI)[B", "([C)[C", "([CI)[C", "([D)[D", "([DI)[D", "([F)[F", "([FI)[F", "([I)[I", "([II)[I", "([J)[J", "([JI)[J", "([S)[S", "([SI)[S", "copyOfRangeInline", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "copyOfRange", "([ZII)[Z", "([BII)[B", "([CII)[C", "([DII)[D", "([FII)[F", "([III)[I", "([JII)[J", "([SII)[S", "copyOfRangeImpl", "index", "elementAt", "([Ljava/lang/Object;I)Ljava/lang/Object;", "([ZI)Z", "([BI)B", "([CI)C", "([DI)D", "([FI)F", "([II)I", "([JI)J", "([SI)S", "", "fill", "([Ljava/lang/Object;Ljava/lang/Object;II)V", "([ZZII)V", "([BBII)V", "([CCII)V", "([DDII)V", "([FFII)V", "([IIII)V", "([JJII)V", "([SSII)V", "R", "Ljava/lang/Class;", "klass", "filterIsInstance", "([Ljava/lang/Object;Ljava/lang/Class;)Ljava/util/List;", "", "C", "filterIsInstanceTo", "([Ljava/lang/Object;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "plus", "([Ljava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "elements", "([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;", "", "([Ljava/lang/Object;Ljava/util/Collection;)[Ljava/lang/Object;", "([ZZ)[Z", "([Z[Z)[Z", "([ZLjava/util/Collection;)[Z", "([BB)[B", "([B[B)[B", "([BLjava/util/Collection;)[B", "([CC)[C", "([C[C)[C", "([CLjava/util/Collection;)[C", "([DD)[D", "([D[D)[D", "([DLjava/util/Collection;)[D", "([FF)[F", "([F[F)[F", "([FLjava/util/Collection;)[F", "([I[I)[I", "([ILjava/util/Collection;)[I", "([JJ)[J", "([J[J)[J", "([JLjava/util/Collection;)[J", "([SS)[S", "([S[S)[S", "([SLjava/util/Collection;)[S", "plusElement", QuickPersistConfigConst.KEY_SPLASH_SORT, "([Ljava/lang/Object;)V", "", "([Ljava/lang/Comparable;)V", "([Ljava/lang/Object;II)V", "([B)V", "([BII)V", "([C)V", "([CII)V", "([D)V", "([DII)V", "([F)V", "([FII)V", "([I)V", "([III)V", "([J)V", "([JII)V", "([S)V", "([SII)V", "sortWith", "([Ljava/lang/Object;Ljava/util/Comparator;)V", "([Ljava/lang/Object;Ljava/util/Comparator;II)V", "Ljava/util/SortedSet;", "toSortedSet", "([Ljava/lang/Comparable;)Ljava/util/SortedSet;", "([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/util/SortedSet;", "([Z)Ljava/util/SortedSet;", "([B)Ljava/util/SortedSet;", "([C)Ljava/util/SortedSet;", "([D)Ljava/util/SortedSet;", "([F)Ljava/util/SortedSet;", "([I)Ljava/util/SortedSet;", "([J)Ljava/util/SortedSet;", "([S)Ljava/util/SortedSet;", "toTypedArray", "([Z)[Ljava/lang/Boolean;", "([B)[Ljava/lang/Byte;", "([C)[Ljava/lang/Character;", "([D)[Ljava/lang/Double;", "([F)[Ljava/lang/Float;", "([I)[Ljava/lang/Integer;", "([J)[Ljava/lang/Long;", "([S)[Ljava/lang/Short;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/collections/ArraysKt")
/* loaded from: classes7.dex */
public class ArraysKt___ArraysJvmKt extends ArraysKt__ArraysKt {
    public static final <T> List<T> asList(T[] tArr) {
        List<T> asList = ArraysUtilJVM.asList(tArr);
        Intrinsics.checkExpressionValueIsNotNull(asList, "ArraysUtilJVM.asList(this)");
        return asList;
    }

    public static final <T> int binarySearch(T[] tArr, T t, Comparator<? super T> comparator, int i, int i2) {
        return Arrays.binarySearch(tArr, i, i2, t, comparator);
    }

    public static /* synthetic */ int binarySearch$default(Object[] objArr, Object obj, Comparator comparator, int i, int i2, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = objArr.length;
        }
        return binarySearch(objArr, obj, comparator, i, i2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    @JvmName(name = "contentDeepEqualsInline")
    public static final <T> boolean contentDeepEqualsInline(T[] tArr, T[] tArr2) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return ArraysKt__ArraysKt.contentDeepEquals(tArr, tArr2);
        }
        return Arrays.deepEquals(tArr, tArr2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    @JvmName(name = "contentDeepHashCodeInline")
    public static final <T> int contentDeepHashCodeInline(T[] tArr) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return ArraysKt__ArraysJVMKt.contentDeepHashCode(tArr);
        }
        return Arrays.deepHashCode(tArr);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    @JvmName(name = "contentDeepToStringInline")
    public static final <T> String contentDeepToStringInline(T[] tArr) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return ArraysKt__ArraysKt.contentDeepToString(tArr);
        }
        String deepToString = Arrays.deepToString(tArr);
        Intrinsics.checkExpressionValueIsNotNull(deepToString, "java.util.Arrays.deepToString(this)");
        return deepToString;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final <T> boolean contentEquals(T[] tArr, T[] tArr2) {
        return Arrays.equals(tArr, tArr2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final <T> int contentHashCode(T[] tArr) {
        return Arrays.hashCode(tArr);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final <T> String contentToString(T[] tArr) {
        String arrays = Arrays.toString(tArr);
        Intrinsics.checkExpressionValueIsNotNull(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @SinceKotlin(version = "1.3")
    public static final <T> T[] copyInto(T[] tArr, T[] tArr2, int i, int i2, int i3) {
        System.arraycopy(tArr, i2, tArr2, i, i3 - i2);
        return tArr2;
    }

    public static /* synthetic */ Object[] copyInto$default(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return copyInto(objArr, objArr2, i, i2, i3);
    }

    @InlineOnly
    public static final <T> T[] copyOf(T[] tArr) {
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        Intrinsics.checkExpressionValueIsNotNull(tArr2, "java.util.Arrays.copyOf(this, size)");
        return tArr2;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "copyOfRange")
    public static final <T> T[] copyOfRange(T[] tArr, int i, int i2) {
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i, i2);
        Intrinsics.checkExpressionValueIsNotNull(tArr2, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return tArr2;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    public static final <T> T[] copyOfRangeInline(T[] tArr, int i, int i2) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return (T[]) copyOfRange(tArr, i, i2);
        }
        if (i2 <= tArr.length) {
            T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i, i2);
            Intrinsics.checkExpressionValueIsNotNull(tArr2, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return tArr2;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + tArr.length);
    }

    @InlineOnly
    public static final <T> T elementAt(T[] tArr, int i) {
        return tArr[i];
    }

    public static final <T> void fill(T[] tArr, T t, int i, int i2) {
        Arrays.fill(tArr, i, i2, t);
    }

    public static /* synthetic */ void fill$default(Object[] objArr, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        fill(objArr, obj, i, i2);
    }

    public static final <R> List<R> filterIsInstance(Object[] objArr, Class<R> cls) {
        return (List) filterIsInstanceTo(objArr, new ArrayList(), cls);
    }

    public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(Object[] objArr, C c2, Class<R> cls) {
        for (Object obj : objArr) {
            if (cls.isInstance(obj)) {
                c2.add(obj);
            }
        }
        return c2;
    }

    public static final <T> T[] plus(T[] tArr, T t) {
        int length = tArr.length;
        T[] result = (T[]) Arrays.copyOf(tArr, length + 1);
        result[length] = t;
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @InlineOnly
    public static final <T> T[] plusElement(T[] tArr, T t) {
        return (T[]) plus(tArr, t);
    }

    public static final void sort(int[] iArr) {
        if (iArr.length > 1) {
            Arrays.sort(iArr);
        }
    }

    public static /* synthetic */ void sort$default(Object[] objArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = objArr.length;
        }
        sort(objArr, i, i2);
    }

    public static final <T> void sortWith(T[] tArr, Comparator<? super T> comparator) {
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static /* synthetic */ void sortWith$default(Object[] objArr, Comparator comparator, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        sortWith(objArr, comparator, i, i2);
    }

    public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(T[] tArr) {
        return (SortedSet) ArraysKt___ArraysKt.toCollection(tArr, new TreeSet());
    }

    public static final Byte[] toTypedArray(byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            bArr2[i] = Byte.valueOf(bArr[i]);
        }
        return bArr2;
    }

    public static final List<Byte> asList(byte[] bArr) {
        return new ArraysKt___ArraysJvmKt$asList$1(bArr);
    }

    public static final <T> int binarySearch(T[] tArr, T t, int i, int i2) {
        return Arrays.binarySearch(tArr, i, i2, t);
    }

    public static /* synthetic */ int binarySearch$default(Object[] objArr, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        return binarySearch(objArr, obj, i, i2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final boolean contentEquals(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final int contentHashCode(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final String contentToString(byte[] bArr) {
        String arrays = Arrays.toString(bArr);
        Intrinsics.checkExpressionValueIsNotNull(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @SinceKotlin(version = "1.3")
    public static final byte[] copyInto(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        System.arraycopy(bArr, i2, bArr2, i, i3 - i2);
        return bArr2;
    }

    public static /* synthetic */ byte[] copyInto$default(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = bArr.length;
        }
        return copyInto(bArr, bArr2, i, i2, i3);
    }

    @InlineOnly
    public static final byte[] copyOf(byte[] bArr) {
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @InlineOnly
    public static final byte elementAt(byte[] bArr, int i) {
        return bArr[i];
    }

    public static final void fill(byte[] bArr, byte b2, int i, int i2) {
        Arrays.fill(bArr, i, i2, b2);
    }

    public static /* synthetic */ void fill$default(byte[] bArr, byte b2, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        fill(bArr, b2, i, i2);
    }

    public static final void sort(long[] jArr) {
        if (jArr.length > 1) {
            Arrays.sort(jArr);
        }
    }

    public static /* synthetic */ void sort$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        sort(bArr, i, i2);
    }

    public static final <T> void sortWith(T[] tArr, Comparator<? super T> comparator, int i, int i2) {
        Arrays.sort(tArr, i, i2, comparator);
    }

    public static final SortedSet<Byte> toSortedSet(byte[] bArr) {
        return (SortedSet) ArraysKt___ArraysKt.toCollection(bArr, new TreeSet());
    }

    public static final List<Short> asList(short[] sArr) {
        return new ArraysKt___ArraysJvmKt$asList$2(sArr);
    }

    public static final int binarySearch(byte[] bArr, byte b2, int i, int i2) {
        return Arrays.binarySearch(bArr, i, i2, b2);
    }

    public static /* synthetic */ int binarySearch$default(byte[] bArr, byte b2, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return binarySearch(bArr, b2, i, i2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final boolean contentEquals(short[] sArr, short[] sArr2) {
        return Arrays.equals(sArr, sArr2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final int contentHashCode(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final String contentToString(short[] sArr) {
        String arrays = Arrays.toString(sArr);
        Intrinsics.checkExpressionValueIsNotNull(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @SinceKotlin(version = "1.3")
    public static final short[] copyInto(short[] sArr, short[] sArr2, int i, int i2, int i3) {
        System.arraycopy(sArr, i2, sArr2, i, i3 - i2);
        return sArr2;
    }

    public static /* synthetic */ short[] copyInto$default(short[] sArr, short[] sArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = sArr.length;
        }
        return copyInto(sArr, sArr2, i, i2, i3);
    }

    @InlineOnly
    public static final short[] copyOf(short[] sArr) {
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "copyOfRange")
    public static final byte[] copyOfRange(byte[] bArr, int i, int i2) {
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i2);
        Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @InlineOnly
    public static final short elementAt(short[] sArr, int i) {
        return sArr[i];
    }

    public static final void fill(short[] sArr, short s, int i, int i2) {
        Arrays.fill(sArr, i, i2, s);
    }

    public static /* synthetic */ void fill$default(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length;
        }
        fill(sArr, s, i, i2);
    }

    public static final void sort(byte[] bArr) {
        if (bArr.length > 1) {
            Arrays.sort(bArr);
        }
    }

    public static /* synthetic */ void sort$default(short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = sArr.length;
        }
        sort(sArr, i, i2);
    }

    public static final SortedSet<Short> toSortedSet(short[] sArr) {
        return (SortedSet) ArraysKt___ArraysKt.toCollection(sArr, new TreeSet());
    }

    public static final List<Integer> asList(int[] iArr) {
        return new ArraysKt___ArraysJvmKt$asList$3(iArr);
    }

    public static final int binarySearch(short[] sArr, short s, int i, int i2) {
        return Arrays.binarySearch(sArr, i, i2, s);
    }

    public static /* synthetic */ int binarySearch$default(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length;
        }
        return binarySearch(sArr, s, i, i2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final boolean contentEquals(int[] iArr, int[] iArr2) {
        return Arrays.equals(iArr, iArr2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final int contentHashCode(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final String contentToString(int[] iArr) {
        String arrays = Arrays.toString(iArr);
        Intrinsics.checkExpressionValueIsNotNull(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @SinceKotlin(version = "1.3")
    public static final int[] copyInto(int[] iArr, int[] iArr2, int i, int i2, int i3) {
        System.arraycopy(iArr, i2, iArr2, i, i3 - i2);
        return iArr2;
    }

    public static /* synthetic */ int[] copyInto$default(int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = iArr.length;
        }
        return copyInto(iArr, iArr2, i, i2, i3);
    }

    @InlineOnly
    public static final int[] copyOf(int[] iArr) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @InlineOnly
    public static final int elementAt(int[] iArr, int i) {
        return iArr[i];
    }

    public static final void fill(int[] iArr, int i, int i2, int i3) {
        Arrays.fill(iArr, i2, i3, i);
    }

    public static /* synthetic */ void fill$default(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = iArr.length;
        }
        fill(iArr, i, i2, i3);
    }

    public static final void sort(short[] sArr) {
        if (sArr.length > 1) {
            Arrays.sort(sArr);
        }
    }

    public static /* synthetic */ void sort$default(int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = iArr.length;
        }
        sort(iArr, i, i2);
    }

    public static final SortedSet<Integer> toSortedSet(int[] iArr) {
        return (SortedSet) ArraysKt___ArraysKt.toCollection(iArr, new TreeSet());
    }

    public static final Short[] toTypedArray(short[] sArr) {
        Short[] shArr = new Short[sArr.length];
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            shArr[i] = Short.valueOf(sArr[i]);
        }
        return shArr;
    }

    public static final List<Long> asList(long[] jArr) {
        return new ArraysKt___ArraysJvmKt$asList$4(jArr);
    }

    public static final int binarySearch(int[] iArr, int i, int i2, int i3) {
        return Arrays.binarySearch(iArr, i2, i3, i);
    }

    public static /* synthetic */ int binarySearch$default(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = iArr.length;
        }
        return binarySearch(iArr, i, i2, i3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final boolean contentEquals(long[] jArr, long[] jArr2) {
        return Arrays.equals(jArr, jArr2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final int contentHashCode(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final String contentToString(long[] jArr) {
        String arrays = Arrays.toString(jArr);
        Intrinsics.checkExpressionValueIsNotNull(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @SinceKotlin(version = "1.3")
    public static final long[] copyInto(long[] jArr, long[] jArr2, int i, int i2, int i3) {
        System.arraycopy(jArr, i2, jArr2, i, i3 - i2);
        return jArr2;
    }

    public static /* synthetic */ long[] copyInto$default(long[] jArr, long[] jArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = jArr.length;
        }
        return copyInto(jArr, jArr2, i, i2, i3);
    }

    @InlineOnly
    public static final long[] copyOf(long[] jArr) {
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "copyOfRange")
    public static final short[] copyOfRange(short[] sArr, int i, int i2) {
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, sArr.length);
        short[] copyOfRange = Arrays.copyOfRange(sArr, i, i2);
        Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @InlineOnly
    public static final long elementAt(long[] jArr, int i) {
        return jArr[i];
    }

    public static final void fill(long[] jArr, long j, int i, int i2) {
        Arrays.fill(jArr, i, i2, j);
    }

    public static /* synthetic */ void fill$default(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length;
        }
        fill(jArr, j, i, i2);
    }

    public static final byte[] plus(byte[] bArr, byte b2) {
        int length = bArr.length;
        byte[] result = Arrays.copyOf(bArr, length + 1);
        result[length] = b2;
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public static final void sort(double[] dArr) {
        if (dArr.length > 1) {
            Arrays.sort(dArr);
        }
    }

    public static /* synthetic */ void sort$default(long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = jArr.length;
        }
        sort(jArr, i, i2);
    }

    public static final SortedSet<Long> toSortedSet(long[] jArr) {
        return (SortedSet) ArraysKt___ArraysKt.toCollection(jArr, new TreeSet());
    }

    public static final List<Float> asList(float[] fArr) {
        return new ArraysKt___ArraysJvmKt$asList$5(fArr);
    }

    public static final int binarySearch(long[] jArr, long j, int i, int i2) {
        return Arrays.binarySearch(jArr, i, i2, j);
    }

    public static /* synthetic */ int binarySearch$default(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length;
        }
        return binarySearch(jArr, j, i, i2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final boolean contentEquals(float[] fArr, float[] fArr2) {
        return Arrays.equals(fArr, fArr2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final int contentHashCode(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final String contentToString(float[] fArr) {
        String arrays = Arrays.toString(fArr);
        Intrinsics.checkExpressionValueIsNotNull(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @SinceKotlin(version = "1.3")
    public static final float[] copyInto(float[] fArr, float[] fArr2, int i, int i2, int i3) {
        System.arraycopy(fArr, i2, fArr2, i, i3 - i2);
        return fArr2;
    }

    public static /* synthetic */ float[] copyInto$default(float[] fArr, float[] fArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = fArr.length;
        }
        return copyInto(fArr, fArr2, i, i2, i3);
    }

    @InlineOnly
    public static final float[] copyOf(float[] fArr) {
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    public static final byte[] copyOfRangeInline(byte[] bArr, int i, int i2) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(bArr, i, i2);
        }
        if (i2 <= bArr.length) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i2);
            Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + bArr.length);
    }

    @InlineOnly
    public static final float elementAt(float[] fArr, int i) {
        return fArr[i];
    }

    public static final void fill(float[] fArr, float f2, int i, int i2) {
        Arrays.fill(fArr, i, i2, f2);
    }

    public static /* synthetic */ void fill$default(float[] fArr, float f2, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length;
        }
        fill(fArr, f2, i, i2);
    }

    public static final void sort(float[] fArr) {
        if (fArr.length > 1) {
            Arrays.sort(fArr);
        }
    }

    public static /* synthetic */ void sort$default(float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = fArr.length;
        }
        sort(fArr, i, i2);
    }

    public static final SortedSet<Float> toSortedSet(float[] fArr) {
        return (SortedSet) ArraysKt___ArraysKt.toCollection(fArr, new TreeSet());
    }

    public static final List<Double> asList(double[] dArr) {
        return new ArraysKt___ArraysJvmKt$asList$6(dArr);
    }

    public static final int binarySearch(float[] fArr, float f2, int i, int i2) {
        return Arrays.binarySearch(fArr, i, i2, f2);
    }

    public static /* synthetic */ int binarySearch$default(float[] fArr, float f2, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length;
        }
        return binarySearch(fArr, f2, i, i2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final boolean contentEquals(double[] dArr, double[] dArr2) {
        return Arrays.equals(dArr, dArr2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final int contentHashCode(double[] dArr) {
        return Arrays.hashCode(dArr);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final String contentToString(double[] dArr) {
        String arrays = Arrays.toString(dArr);
        Intrinsics.checkExpressionValueIsNotNull(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @SinceKotlin(version = "1.3")
    public static final double[] copyInto(double[] dArr, double[] dArr2, int i, int i2, int i3) {
        System.arraycopy(dArr, i2, dArr2, i, i3 - i2);
        return dArr2;
    }

    public static /* synthetic */ double[] copyInto$default(double[] dArr, double[] dArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = dArr.length;
        }
        return copyInto(dArr, dArr2, i, i2, i3);
    }

    @InlineOnly
    public static final double[] copyOf(double[] dArr) {
        double[] copyOf = Arrays.copyOf(dArr, dArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "copyOfRange")
    public static final int[] copyOfRange(int[] iArr, int i, int i2) {
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, iArr.length);
        int[] copyOfRange = Arrays.copyOfRange(iArr, i, i2);
        Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @InlineOnly
    public static final double elementAt(double[] dArr, int i) {
        return dArr[i];
    }

    public static final void fill(double[] dArr, double d2, int i, int i2) {
        Arrays.fill(dArr, i, i2, d2);
    }

    public static /* synthetic */ void fill$default(double[] dArr, double d2, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length;
        }
        fill(dArr, d2, i, i2);
    }

    public static final void sort(char[] cArr) {
        if (cArr.length > 1) {
            Arrays.sort(cArr);
        }
    }

    public static /* synthetic */ void sort$default(double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = dArr.length;
        }
        sort(dArr, i, i2);
    }

    public static final SortedSet<Double> toSortedSet(double[] dArr) {
        return (SortedSet) ArraysKt___ArraysKt.toCollection(dArr, new TreeSet());
    }

    public static final Integer[] toTypedArray(int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    public static final List<Boolean> asList(boolean[] zArr) {
        return new ArraysKt___ArraysJvmKt$asList$7(zArr);
    }

    public static final int binarySearch(double[] dArr, double d2, int i, int i2) {
        return Arrays.binarySearch(dArr, i, i2, d2);
    }

    public static /* synthetic */ int binarySearch$default(double[] dArr, double d2, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length;
        }
        return binarySearch(dArr, d2, i, i2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final boolean contentEquals(boolean[] zArr, boolean[] zArr2) {
        return Arrays.equals(zArr, zArr2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final int contentHashCode(boolean[] zArr) {
        return Arrays.hashCode(zArr);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final String contentToString(boolean[] zArr) {
        String arrays = Arrays.toString(zArr);
        Intrinsics.checkExpressionValueIsNotNull(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @SinceKotlin(version = "1.3")
    public static final boolean[] copyInto(boolean[] zArr, boolean[] zArr2, int i, int i2, int i3) {
        System.arraycopy(zArr, i2, zArr2, i, i3 - i2);
        return zArr2;
    }

    public static /* synthetic */ boolean[] copyInto$default(boolean[] zArr, boolean[] zArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = zArr.length;
        }
        return copyInto(zArr, zArr2, i, i2, i3);
    }

    @InlineOnly
    public static final boolean[] copyOf(boolean[] zArr) {
        boolean[] copyOf = Arrays.copyOf(zArr, zArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @InlineOnly
    public static final boolean elementAt(boolean[] zArr, int i) {
        return zArr[i];
    }

    public static final void fill(boolean[] zArr, boolean z, int i, int i2) {
        Arrays.fill(zArr, i, i2, z);
    }

    public static /* synthetic */ void fill$default(boolean[] zArr, boolean z, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = zArr.length;
        }
        fill(zArr, z, i, i2);
    }

    @InlineOnly
    public static final <T extends Comparable<? super T>> void sort(T[] tArr) {
        if (tArr == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        sort((Object[]) tArr);
    }

    public static /* synthetic */ void sort$default(char[] cArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = cArr.length;
        }
        sort(cArr, i, i2);
    }

    public static final SortedSet<Boolean> toSortedSet(boolean[] zArr) {
        return (SortedSet) ArraysKt___ArraysKt.toCollection(zArr, new TreeSet());
    }

    public static final List<Character> asList(char[] cArr) {
        return new ArraysKt___ArraysJvmKt$asList$8(cArr);
    }

    public static final int binarySearch(char[] cArr, char c2, int i, int i2) {
        return Arrays.binarySearch(cArr, i, i2, c2);
    }

    public static /* synthetic */ int binarySearch$default(char[] cArr, char c2, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        return binarySearch(cArr, c2, i, i2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final boolean contentEquals(char[] cArr, char[] cArr2) {
        return Arrays.equals(cArr, cArr2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final int contentHashCode(char[] cArr) {
        return Arrays.hashCode(cArr);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final String contentToString(char[] cArr) {
        String arrays = Arrays.toString(cArr);
        Intrinsics.checkExpressionValueIsNotNull(arrays, "java.util.Arrays.toString(this)");
        return arrays;
    }

    @SinceKotlin(version = "1.3")
    public static final char[] copyInto(char[] cArr, char[] cArr2, int i, int i2, int i3) {
        System.arraycopy(cArr, i2, cArr2, i, i3 - i2);
        return cArr2;
    }

    public static /* synthetic */ char[] copyInto$default(char[] cArr, char[] cArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = cArr.length;
        }
        return copyInto(cArr, cArr2, i, i2, i3);
    }

    @InlineOnly
    public static final char[] copyOf(char[] cArr) {
        char[] copyOf = Arrays.copyOf(cArr, cArr.length);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "copyOfRange")
    public static final long[] copyOfRange(long[] jArr, int i, int i2) {
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, jArr.length);
        long[] copyOfRange = Arrays.copyOfRange(jArr, i, i2);
        Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @InlineOnly
    public static final char elementAt(char[] cArr, int i) {
        return cArr[i];
    }

    public static final void fill(char[] cArr, char c2, int i, int i2) {
        Arrays.fill(cArr, i, i2, c2);
    }

    public static /* synthetic */ void fill$default(char[] cArr, char c2, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        fill(cArr, c2, i, i2);
    }

    public static final short[] plus(short[] sArr, short s) {
        int length = sArr.length;
        short[] result = Arrays.copyOf(sArr, length + 1);
        result[length] = s;
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public static final <T> void sort(T[] tArr) {
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    public static final SortedSet<Character> toSortedSet(char[] cArr) {
        return (SortedSet) ArraysKt___ArraysKt.toCollection(cArr, new TreeSet());
    }

    @InlineOnly
    public static final byte[] copyOf(byte[] bArr, int i) {
        byte[] copyOf = Arrays.copyOf(bArr, i);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    public static final <T> void sort(T[] tArr, int i, int i2) {
        Arrays.sort(tArr, i, i2);
    }

    public static final <T> SortedSet<T> toSortedSet(T[] tArr, Comparator<? super T> comparator) {
        return (SortedSet) ArraysKt___ArraysKt.toCollection(tArr, new TreeSet(comparator));
    }

    public static final Long[] toTypedArray(long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        return lArr;
    }

    @InlineOnly
    public static final short[] copyOf(short[] sArr, int i) {
        short[] copyOf = Arrays.copyOf(sArr, i);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "copyOfRange")
    public static final float[] copyOfRange(float[] fArr, int i, int i2) {
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, fArr.length);
        float[] copyOfRange = Arrays.copyOfRange(fArr, i, i2);
        Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    public static final short[] copyOfRangeInline(short[] sArr, int i, int i2) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(sArr, i, i2);
        }
        if (i2 <= sArr.length) {
            short[] copyOfRange = Arrays.copyOfRange(sArr, i, i2);
            Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + sArr.length);
    }

    public static final void sort(byte[] bArr, int i, int i2) {
        Arrays.sort(bArr, i, i2);
    }

    @InlineOnly
    public static final int[] copyOf(int[] iArr, int i) {
        int[] copyOf = Arrays.copyOf(iArr, i);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    public static final void sort(short[] sArr, int i, int i2) {
        Arrays.sort(sArr, i, i2);
    }

    @InlineOnly
    public static final long[] copyOf(long[] jArr, int i) {
        long[] copyOf = Arrays.copyOf(jArr, i);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "copyOfRange")
    public static final double[] copyOfRange(double[] dArr, int i, int i2) {
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, dArr.length);
        double[] copyOfRange = Arrays.copyOfRange(dArr, i, i2);
        Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static final int[] plus(int[] iArr, int i) {
        int length = iArr.length;
        int[] result = Arrays.copyOf(iArr, length + 1);
        result[length] = i;
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public static final void sort(int[] iArr, int i, int i2) {
        Arrays.sort(iArr, i, i2);
    }

    public static final Float[] toTypedArray(float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            fArr2[i] = Float.valueOf(fArr[i]);
        }
        return fArr2;
    }

    @InlineOnly
    public static final float[] copyOf(float[] fArr, int i) {
        float[] copyOf = Arrays.copyOf(fArr, i);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    public static final void sort(long[] jArr, int i, int i2) {
        Arrays.sort(jArr, i, i2);
    }

    @InlineOnly
    public static final double[] copyOf(double[] dArr, int i) {
        double[] copyOf = Arrays.copyOf(dArr, i);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "copyOfRange")
    public static final boolean[] copyOfRange(boolean[] zArr, int i, int i2) {
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, zArr.length);
        boolean[] copyOfRange = Arrays.copyOfRange(zArr, i, i2);
        Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static final void sort(float[] fArr, int i, int i2) {
        Arrays.sort(fArr, i, i2);
    }

    @InlineOnly
    public static final boolean[] copyOf(boolean[] zArr, int i) {
        boolean[] copyOf = Arrays.copyOf(zArr, i);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    public static final int[] copyOfRangeInline(int[] iArr, int i, int i2) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(iArr, i, i2);
        }
        if (i2 <= iArr.length) {
            int[] copyOfRange = Arrays.copyOfRange(iArr, i, i2);
            Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + iArr.length);
    }

    public static final void sort(double[] dArr, int i, int i2) {
        Arrays.sort(dArr, i, i2);
    }

    public static final Double[] toTypedArray(double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            dArr2[i] = Double.valueOf(dArr[i]);
        }
        return dArr2;
    }

    @InlineOnly
    public static final char[] copyOf(char[] cArr, int i) {
        char[] copyOf = Arrays.copyOf(cArr, i);
        Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @JvmName(name = "copyOfRange")
    public static final char[] copyOfRange(char[] cArr, int i, int i2) {
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, cArr.length);
        char[] copyOfRange = Arrays.copyOfRange(cArr, i, i2);
        Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static final long[] plus(long[] jArr, long j) {
        int length = jArr.length;
        long[] result = Arrays.copyOf(jArr, length + 1);
        result[length] = j;
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public static final void sort(char[] cArr, int i, int i2) {
        Arrays.sort(cArr, i, i2);
    }

    @InlineOnly
    public static final <T> T[] copyOf(T[] tArr, int i) {
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i);
        Intrinsics.checkExpressionValueIsNotNull(tArr2, "java.util.Arrays.copyOf(this, newSize)");
        return tArr2;
    }

    public static final Boolean[] toTypedArray(boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            boolArr[i] = Boolean.valueOf(zArr[i]);
        }
        return boolArr;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    public static final long[] copyOfRangeInline(long[] jArr, int i, int i2) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(jArr, i, i2);
        }
        if (i2 <= jArr.length) {
            long[] copyOfRange = Arrays.copyOfRange(jArr, i, i2);
            Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + jArr.length);
    }

    public static final float[] plus(float[] fArr, float f2) {
        int length = fArr.length;
        float[] result = Arrays.copyOf(fArr, length + 1);
        result[length] = f2;
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public static final Character[] toTypedArray(char[] cArr) {
        Character[] chArr = new Character[cArr.length];
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            chArr[i] = Character.valueOf(cArr[i]);
        }
        return chArr;
    }

    public static final double[] plus(double[] dArr, double d2) {
        int length = dArr.length;
        double[] result = Arrays.copyOf(dArr, length + 1);
        result[length] = d2;
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    public static final float[] copyOfRangeInline(float[] fArr, int i, int i2) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(fArr, i, i2);
        }
        if (i2 <= fArr.length) {
            float[] copyOfRange = Arrays.copyOfRange(fArr, i, i2);
            Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + fArr.length);
    }

    public static final boolean[] plus(boolean[] zArr, boolean z) {
        int length = zArr.length;
        boolean[] result = Arrays.copyOf(zArr, length + 1);
        result[length] = z;
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    public static final double[] copyOfRangeInline(double[] dArr, int i, int i2) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(dArr, i, i2);
        }
        if (i2 <= dArr.length) {
            double[] copyOfRange = Arrays.copyOfRange(dArr, i, i2);
            Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + dArr.length);
    }

    public static final char[] plus(char[] cArr, char c2) {
        int length = cArr.length;
        char[] result = Arrays.copyOf(cArr, length + 1);
        result[length] = c2;
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    public static final boolean[] copyOfRangeInline(boolean[] zArr, int i, int i2) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(zArr, i, i2);
        }
        if (i2 <= zArr.length) {
            boolean[] copyOfRange = Arrays.copyOfRange(zArr, i, i2);
            Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + zArr.length);
    }

    public static final <T> T[] plus(T[] tArr, Collection<? extends T> collection) {
        int length = tArr.length;
        T[] result = (T[]) Arrays.copyOf(tArr, collection.size() + length);
        for (T t : collection) {
            result[length] = t;
            length++;
        }
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    @InlineOnly
    @JvmName(name = "copyOfRangeInline")
    public static final char[] copyOfRangeInline(char[] cArr, int i, int i2) {
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
            return copyOfRange(cArr, i, i2);
        }
        if (i2 <= cArr.length) {
            char[] copyOfRange = Arrays.copyOfRange(cArr, i, i2);
            Intrinsics.checkExpressionValueIsNotNull(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i2 + ", size: " + cArr.length);
    }

    public static final byte[] plus(byte[] bArr, Collection<Byte> collection) {
        int length = bArr.length;
        byte[] result = Arrays.copyOf(bArr, collection.size() + length);
        for (Byte b2 : collection) {
            result[length] = b2.byteValue();
            length++;
        }
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public static final short[] plus(short[] sArr, Collection<Short> collection) {
        int length = sArr.length;
        short[] result = Arrays.copyOf(sArr, collection.size() + length);
        for (Short sh : collection) {
            result[length] = sh.shortValue();
            length++;
        }
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public static final int[] plus(int[] iArr, Collection<Integer> collection) {
        int length = iArr.length;
        int[] result = Arrays.copyOf(iArr, collection.size() + length);
        for (Integer num : collection) {
            result[length] = num.intValue();
            length++;
        }
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public static final long[] plus(long[] jArr, Collection<Long> collection) {
        int length = jArr.length;
        long[] result = Arrays.copyOf(jArr, collection.size() + length);
        for (Long l : collection) {
            result[length] = l.longValue();
            length++;
        }
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public static final float[] plus(float[] fArr, Collection<Float> collection) {
        int length = fArr.length;
        float[] result = Arrays.copyOf(fArr, collection.size() + length);
        for (Float f2 : collection) {
            result[length] = f2.floatValue();
            length++;
        }
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public static final double[] plus(double[] dArr, Collection<Double> collection) {
        int length = dArr.length;
        double[] result = Arrays.copyOf(dArr, collection.size() + length);
        for (Double d2 : collection) {
            result[length] = d2.doubleValue();
            length++;
        }
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public static final boolean[] plus(boolean[] zArr, Collection<Boolean> collection) {
        int length = zArr.length;
        boolean[] result = Arrays.copyOf(zArr, collection.size() + length);
        for (Boolean bool : collection) {
            result[length] = bool.booleanValue();
            length++;
        }
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public static final char[] plus(char[] cArr, Collection<Character> collection) {
        int length = cArr.length;
        char[] result = Arrays.copyOf(cArr, collection.size() + length);
        for (Character ch : collection) {
            result[length] = ch.charValue();
            length++;
        }
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public static final <T> T[] plus(T[] tArr, T[] tArr2) {
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] result = (T[]) Arrays.copyOf(tArr, length + length2);
        System.arraycopy(tArr2, 0, result, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public static final byte[] plus(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] result = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(bArr2, 0, result, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public static final short[] plus(short[] sArr, short[] sArr2) {
        int length = sArr.length;
        int length2 = sArr2.length;
        short[] result = Arrays.copyOf(sArr, length + length2);
        System.arraycopy(sArr2, 0, result, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public static final int[] plus(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int length2 = iArr2.length;
        int[] result = Arrays.copyOf(iArr, length + length2);
        System.arraycopy(iArr2, 0, result, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public static final long[] plus(long[] jArr, long[] jArr2) {
        int length = jArr.length;
        int length2 = jArr2.length;
        long[] result = Arrays.copyOf(jArr, length + length2);
        System.arraycopy(jArr2, 0, result, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public static final float[] plus(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        int length2 = fArr2.length;
        float[] result = Arrays.copyOf(fArr, length + length2);
        System.arraycopy(fArr2, 0, result, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public static final double[] plus(double[] dArr, double[] dArr2) {
        int length = dArr.length;
        int length2 = dArr2.length;
        double[] result = Arrays.copyOf(dArr, length + length2);
        System.arraycopy(dArr2, 0, result, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public static final boolean[] plus(boolean[] zArr, boolean[] zArr2) {
        int length = zArr.length;
        int length2 = zArr2.length;
        boolean[] result = Arrays.copyOf(zArr, length + length2);
        System.arraycopy(zArr2, 0, result, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }

    public static final char[] plus(char[] cArr, char[] cArr2) {
        int length = cArr.length;
        int length2 = cArr2.length;
        char[] result = Arrays.copyOf(cArr, length + length2);
        System.arraycopy(cArr2, 0, result, length, length2);
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        return result;
    }
}
