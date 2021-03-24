package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008c\u0001\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0002\b\n\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\"\u001a%\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a8\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0087\b¢\u0006\u0004\b\u0007\u0010\b\u001aa\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u000b\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\t\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0004\b\u0007\u0010\f\u001a8\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0087\b¢\u0006\u0004\b\u000f\u0010\u0010\u001aa\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u000b\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\t\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0004\b\u000f\u0010\u0011\u001a\u0017\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a(\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0087\b¢\u0006\u0004\b\u0016\u0010\u0004\u001aQ\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u000b\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\t\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0004\b\u0016\u0010\u0017\u001a(\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0018\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0087\b¢\u0006\u0004\b\u0019\u0010\u0004\u001aQ\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0018\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u000b\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\t\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n¢\u0006\u0004\b\u0019\u0010\u0017\u001a,\u0010\u001b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001aH\u0087\n¢\u0006\u0004\b\u001b\u0010\u001c\u001a,\u0010\u001d\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001aH\u0087\n¢\u0006\u0004\b\u001d\u0010\u001c\u001a;\u0010!\u001a\u00020 \"\t\b\u0000\u0010\u0000¢\u0006\u0002\b\u001e\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u001f\u001a\u00028\u0000H\u0087\n¢\u0006\u0004\b!\u0010\"\u001a3\u0010#\u001a\u00020 \"\t\b\u0000\u0010\u0000¢\u0006\u0002\b\u001e*\u000e\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0002\b\u00030\u00022\u0006\u0010\u001f\u001a\u00028\u0000H\u0087\b¢\u0006\u0004\b#\u0010\"\u001a9\u0010%\u001a\u00020 \"\u0004\b\u0000\u0010\u0000\"\t\b\u0001\u0010\u0001¢\u0006\u0002\b\u001e*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010$\u001a\u00028\u0001H\u0087\b¢\u0006\u0004\b%\u0010\"\u001aZ\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a\u0012\u0004\u0012\u00020 0&H\u0086\b¢\u0006\u0004\b(\u0010)\u001aN\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020 0&H\u0086\b¢\u0006\u0004\b*\u0010)\u001aZ\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a\u0012\u0004\u0012\u00020 0&H\u0086\b¢\u0006\u0004\b+\u0010)\u001ap\u0010.\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010,*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u0018*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010-\u001a\u00028\u00022\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a\u0012\u0004\u0012\u00020 0&H\u0086\b¢\u0006\u0004\b.\u0010/\u001ap\u00100\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010,*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u0018*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010-\u001a\u00028\u00022\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a\u0012\u0004\u0012\u00020 0&H\u0086\b¢\u0006\u0004\b0\u0010/\u001aN\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020 0&H\u0086\b¢\u0006\u0004\b1\u0010)\u001a=\u00102\u001a\u0004\u0018\u00018\u0001\"\t\b\u0000\u0010\u0000¢\u0006\u0002\b\u001e\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u001f\u001a\u00028\u0000H\u0087\n¢\u0006\u0004\b2\u00103\u001aB\u00106\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u001f\u001a\u00028\u00002\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u000104H\u0087\b¢\u0006\u0004\b6\u00107\u001aB\u00108\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u001f\u001a\u00028\u00002\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u000104H\u0080\b¢\u0006\u0004\b8\u00107\u001aB\u00109\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00182\u0006\u0010\u001f\u001a\u00028\u00002\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u000104H\u0086\b¢\u0006\u0004\b9\u00107\u001a3\u0010:\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u001f\u001a\u00028\u0000H\u0007¢\u0006\u0004\b:\u00103\u001a>\u0010<\u001a\u00028\u0001\"\u0014\b\u0000\u0010,*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002*\u00028\u0001\"\u0004\b\u0001\u0010;*\u00028\u00002\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u000104H\u0087\b¢\u0006\u0004\b<\u0010=\u001a.\u0010>\u001a\u00020 \"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0087\b¢\u0006\u0004\b>\u0010?\u001aA\u0010@\u001a\u00020 \"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0004\b@\u0010?\u001a@\u0010B\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a0A\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0087\n¢\u0006\u0004\bB\u0010C\u001a>\u0010B\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010E0D\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0018H\u0087\n¢\u0006\u0004\bF\u0010C\u001a`\u0010H\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010;*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010G\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a\u0012\u0004\u0012\u00028\u00020&H\u0086\b¢\u0006\u0004\bH\u0010)\u001av\u0010I\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010;\"\u0018\b\u0003\u0010,*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0002\u0012\u0006\b\u0000\u0012\u00028\u00010\u0018*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010-\u001a\u00028\u00032\u001e\u0010G\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a\u0012\u0004\u0012\u00028\u00020&H\u0086\b¢\u0006\u0004\bI\u0010/\u001a`\u0010J\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010;*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010G\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a\u0012\u0004\u0012\u00028\u00020&H\u0086\b¢\u0006\u0004\bJ\u0010)\u001av\u0010K\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010;\"\u0018\b\u0003\u0010,*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00020\u0018*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010-\u001a\u00028\u00032\u001e\u0010G\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a\u0012\u0004\u0012\u00028\u00020&H\u0086\b¢\u0006\u0004\bK\u0010/\u001aB\u0010L\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u001f\u001a\u00028\u0000H\u0087\u0002¢\u0006\u0004\bL\u0010M\u001aJ\u0010L\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u000e\u0010N\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\tH\u0087\u0002¢\u0006\u0004\bL\u0010O\u001aH\u0010L\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000PH\u0087\u0002¢\u0006\u0004\bL\u0010Q\u001aH\u0010L\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000RH\u0087\u0002¢\u0006\u0004\bL\u0010S\u001a4\u0010U\u001a\u00020T\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00182\u0006\u0010\u001f\u001a\u00028\u0000H\u0087\n¢\u0006\u0004\bU\u0010V\u001a<\u0010U\u001a\u00020T\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00182\u000e\u0010N\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\tH\u0087\n¢\u0006\u0004\bU\u0010W\u001a:\u0010U\u001a\u00020T\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00182\f\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000PH\u0087\n¢\u0006\u0004\bU\u0010X\u001a:\u0010U\u001a\u00020T\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00182\f\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000RH\u0087\n¢\u0006\u0004\bU\u0010Y\u001a7\u0010Z\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0000¢\u0006\u0004\bZ\u0010[\u001a:\u0010\\\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0002H\u0087\b¢\u0006\u0004\b\\\u0010[\u001aV\u0010]\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001a\u0010\u000b\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\tH\u0086\u0002¢\u0006\u0004\b]\u0010^\u001aN\u0010]\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0012\u0010_\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nH\u0086\u0002¢\u0006\u0004\b]\u0010`\u001aT\u0010]\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0PH\u0086\u0002¢\u0006\u0004\b]\u0010Q\u001aP\u0010]\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0014\u0010a\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0086\u0002¢\u0006\u0004\b]\u0010b\u001aT\u0010]\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0RH\u0086\u0002¢\u0006\u0004\b]\u0010S\u001aL\u0010c\u001a\u00020T\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u00182\u001a\u0010\u000b\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\tH\u0087\n¢\u0006\u0004\bc\u0010d\u001aD\u0010c\u001a\u00020T\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u00182\u0012\u0010_\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\nH\u0087\n¢\u0006\u0004\bc\u0010e\u001aJ\u0010c\u001a\u00020T\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u00182\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0PH\u0087\n¢\u0006\u0004\bc\u0010X\u001aD\u0010c\u001a\u00020T\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u00182\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0087\n¢\u0006\u0004\bc\u0010f\u001aJ\u0010c\u001a\u00020T\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u00182\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0RH\u0087\n¢\u0006\u0004\bc\u0010Y\u001aI\u0010g\u001a\u00020T\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u00182\u001a\u0010\u000b\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\t¢\u0006\u0004\bg\u0010d\u001aG\u0010g\u001a\u00020T\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u00182\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0P¢\u0006\u0004\bg\u0010X\u001aG\u0010g\u001a\u00020T\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u00182\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0R¢\u0006\u0004\bg\u0010Y\u001a=\u0010h\u001a\u0004\u0018\u00018\u0001\"\t\b\u0000\u0010\u0000¢\u0006\u0002\b\u001e\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00182\u0006\u0010\u001f\u001a\u00028\u0000H\u0087\b¢\u0006\u0004\bh\u00103\u001a<\u0010i\u001a\u00020T\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00182\u0006\u0010\u001f\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0001H\u0087\n¢\u0006\u0004\bi\u0010j\u001a=\u0010k\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\t¢\u0006\u0004\bk\u0010\u0017\u001aS\u0010k\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010,*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u0018*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\t2\u0006\u0010-\u001a\u00028\u0002¢\u0006\u0004\bk\u0010l\u001a;\u0010k\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0P¢\u0006\u0004\bk\u0010m\u001aQ\u0010k\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010,*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u0018*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0P2\u0006\u0010-\u001a\u00028\u0002¢\u0006\u0004\bk\u0010n\u001a9\u0010k\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007¢\u0006\u0004\bk\u0010[\u001aO\u0010k\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010,*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u0018*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010-\u001a\u00028\u0002H\u0007¢\u0006\u0004\bk\u0010b\u001a;\u0010k\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0R¢\u0006\u0004\bk\u0010o\u001aQ\u0010k\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u0010,*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u0018*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0R2\u0006\u0010-\u001a\u00028\u0002¢\u0006\u0004\bk\u0010p\u001a9\u0010q\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0018\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007¢\u0006\u0004\bq\u0010[\u001a8\u0010r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001aH\u0087\b¢\u0006\u0004\br\u0010s\"\u0016\u0010t\u001a\u00020\u00128\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\bt\u0010u¨\u0006v"}, d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "emptyMap", "()Ljava/util/Map;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "hashMapOf", "()Ljava/util/HashMap;", "", "Lkotlin/Pair;", "pairs", "([Lkotlin/Pair;)Ljava/util/HashMap;", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "linkedMapOf", "()Ljava/util/LinkedHashMap;", "([Lkotlin/Pair;)Ljava/util/LinkedHashMap;", "", "expectedSize", "mapCapacity", "(I)I", "mapOf", "([Lkotlin/Pair;)Ljava/util/Map;", "", "mutableMapOf", "", "component1", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "component2", "Lkotlin/internal/OnlyInputTypes;", "key", "", "contains", "(Ljava/util/Map;Ljava/lang/Object;)Z", "containsKey", "value", "containsValue", "Lkotlin/Function1;", "predicate", CloudControlRequest.REQUEST_KEY_FILTER, "(Ljava/util/Map;Lkotlin/Function1;)Ljava/util/Map;", "filterKeys", "filterNot", "M", "destination", "filterNotTo", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "filterTo", "filterValues", "get", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function0;", "defaultValue", "getOrElse", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrElseNullable", "getOrPut", "getValue", "R", "ifEmpty", "(Ljava/util/Map;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "(Ljava/util/Map;)Z", "isNullOrEmpty", "", "iterator", "(Ljava/util/Map;)Ljava/util/Iterator;", "", "", "mutableIterator", "transform", "mapKeys", "mapKeysTo", "mapValues", "mapValuesTo", "minus", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/util/Map;", "keys", "(Ljava/util/Map;[Ljava/lang/Object;)Ljava/util/Map;", "", "(Ljava/util/Map;Ljava/lang/Iterable;)Ljava/util/Map;", "Lkotlin/sequences/Sequence;", "(Ljava/util/Map;Lkotlin/sequences/Sequence;)Ljava/util/Map;", "", "minusAssign", "(Ljava/util/Map;Ljava/lang/Object;)V", "(Ljava/util/Map;[Ljava/lang/Object;)V", "(Ljava/util/Map;Ljava/lang/Iterable;)V", "(Ljava/util/Map;Lkotlin/sequences/Sequence;)V", "optimizeReadOnlyMap", "(Ljava/util/Map;)Ljava/util/Map;", "orEmpty", "plus", "(Ljava/util/Map;[Lkotlin/Pair;)Ljava/util/Map;", "pair", "(Ljava/util/Map;Lkotlin/Pair;)Ljava/util/Map;", "map", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "plusAssign", "(Ljava/util/Map;[Lkotlin/Pair;)V", "(Ljava/util/Map;Lkotlin/Pair;)V", "(Ljava/util/Map;Ljava/util/Map;)V", "putAll", "remove", "set", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V", "toMap", "([Lkotlin/Pair;Ljava/util/Map;)Ljava/util/Map;", "(Ljava/lang/Iterable;)Ljava/util/Map;", "(Ljava/lang/Iterable;Ljava/util/Map;)Ljava/util/Map;", "(Lkotlin/sequences/Sequence;)Ljava/util/Map;", "(Lkotlin/sequences/Sequence;Ljava/util/Map;)Ljava/util/Map;", "toMutableMap", "toPair", "(Ljava/util/Map$Entry;)Lkotlin/Pair;", "INT_MAX_POWER_OF_TWO", "I", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/collections/MapsKt")
/* loaded from: classes7.dex */
public class MapsKt__MapsKt extends MapsKt__MapsJVMKt {
    public static final int INT_MAX_POWER_OF_TWO = 1073741824;

    @InlineOnly
    public static final <K, V> K component1(Map.Entry<? extends K, ? extends V> entry) {
        return entry.getKey();
    }

    @InlineOnly
    public static final <K, V> V component2(Map.Entry<? extends K, ? extends V> entry) {
        return entry.getValue();
    }

    @InlineOnly
    public static final <K, V> boolean contains(Map<? extends K, ? extends V> map, K k) {
        return map.containsKey(k);
    }

    @InlineOnly
    public static final <K> boolean containsKey(Map<? extends K, ?> map, K k) {
        if (map != null) {
            return map.containsKey(k);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }

    @InlineOnly
    public static final <K, V> boolean containsValue(Map<K, ? extends V> map, V v) {
        return map.containsValue(v);
    }

    public static final <K, V> Map<K, V> emptyMap() {
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        if (emptyMap != null) {
            return emptyMap;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }

    public static final <K, V> Map<K, V> filter(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (function1.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: K, ? super K */
    public static final <K, V> Map<K, V> filterKeys(Map<? extends K, ? extends V> map, Function1<? super K, Boolean> function1) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (function1.invoke((K) entry.getKey()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> filterNot(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!function1.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M filterNotTo(Map<? extends K, ? extends V> map, M m, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!function1.invoke(entry).booleanValue()) {
                m.put(entry.getKey(), entry.getValue());
            }
        }
        return m;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M filterTo(Map<? extends K, ? extends V> map, M m, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (function1.invoke(entry).booleanValue()) {
                m.put(entry.getKey(), entry.getValue());
            }
        }
        return m;
    }

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: V, ? super V */
    public static final <K, V> Map<K, V> filterValues(Map<? extends K, ? extends V> map, Function1<? super V, Boolean> function1) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (function1.invoke((V) entry.getValue()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    @InlineOnly
    public static final <K, V> V get(Map<? extends K, ? extends V> map, K k) {
        return map.get(k);
    }

    @InlineOnly
    public static final <K, V> V getOrElse(Map<K, ? extends V> map, K k, Function0<? extends V> function0) {
        V v = map.get(k);
        return v != null ? v : function0.invoke();
    }

    public static final <K, V> V getOrElseNullable(Map<K, ? extends V> map, K k, Function0<? extends V> function0) {
        V v = map.get(k);
        return (v != null || map.containsKey(k)) ? v : function0.invoke();
    }

    public static final <K, V> V getOrPut(Map<K, V> map, K k, Function0<? extends V> function0) {
        V v = map.get(k);
        if (v == null) {
            V invoke = function0.invoke();
            map.put(k, invoke);
            return invoke;
        }
        return v;
    }

    @SinceKotlin(version = "1.1")
    public static final <K, V> V getValue(Map<K, ? extends V> map, K k) {
        return (V) MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable(map, k);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final <K, V> HashMap<K, V> hashMapOf() {
        return new HashMap<>();
    }

    /* JADX WARN: Incorrect types in method signature: <M::Ljava/util/Map<**>;:TR;R:Ljava/lang/Object;>(TM;Lkotlin/jvm/functions/Function0<+TR;>;)TR; */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final Object ifEmpty(Map map, Function0 function0) {
        return map.isEmpty() ? function0.invoke() : map;
    }

    @InlineOnly
    public static final <K, V> boolean isNotEmpty(Map<? extends K, ? extends V> map) {
        return !map.isEmpty();
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final <K, V> boolean isNullOrEmpty(Map<? extends K, ? extends V> map) {
        return map == null || map.isEmpty();
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java.util.Iterator<java.util.Map$Entry<? extends K, ? extends V>>, java.util.Iterator<java.util.Map$Entry<K, V>> */
    @InlineOnly
    public static final <K, V> Iterator<Map.Entry<K, V>> iterator(Map<? extends K, ? extends V> map) {
        return (Iterator<Map.Entry<? extends K, ? extends V>>) map.entrySet().iterator();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final <K, V> LinkedHashMap<K, V> linkedMapOf() {
        return new LinkedHashMap<>();
    }

    @PublishedApi
    public static final int mapCapacity(int i) {
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return i + (i / 3);
        }
        return Integer.MAX_VALUE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, R> Map<R, V> mapKeys(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity(map.size()));
        for (Object obj : map.entrySet()) {
            linkedHashMap.put(function1.invoke(obj), ((Map.Entry) obj).getValue());
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: M extends java.util.Map<? super R, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, R, M extends Map<? super R, ? super V>> M mapKeysTo(Map<? extends K, ? extends V> map, M m, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        for (Object obj : map.entrySet()) {
            m.put(function1.invoke(obj), ((Map.Entry) obj).getValue());
        }
        return m;
    }

    public static final <K, V> Map<K, V> mapOf(Pair<? extends K, ? extends V>... pairArr) {
        return pairArr.length > 0 ? toMap(pairArr, new LinkedHashMap(mapCapacity(pairArr.length))) : emptyMap();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, R> Map<K, R> mapValues(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity(map.size()));
        for (Object obj : map.entrySet()) {
            linkedHashMap.put(((Map.Entry) obj).getKey(), function1.invoke(obj));
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: M extends java.util.Map<? super K, ? super R> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, R, M extends Map<? super K, ? super R>> M mapValuesTo(Map<? extends K, ? extends V> map, M m, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        for (Object obj : map.entrySet()) {
            m.put(((Map.Entry) obj).getKey(), function1.invoke(obj));
        }
        return m;
    }

    @SinceKotlin(version = "1.1")
    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> map, K k) {
        Map mutableMap = toMutableMap(map);
        mutableMap.remove(k);
        return optimizeReadOnlyMap(mutableMap);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final <K, V> void minusAssign(Map<K, V> map, K k) {
        map.remove(k);
    }

    @InlineOnly
    @JvmName(name = "mutableIterator")
    public static final <K, V> Iterator<Map.Entry<K, V>> mutableIterator(Map<K, V> map) {
        return map.entrySet().iterator();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final <K, V> Map<K, V> mutableMapOf() {
        return new LinkedHashMap();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Map<K, ? extends V> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> optimizeReadOnlyMap(Map<K, ? extends V> map) {
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : MapsKt__MapsJVMKt.toSingletonMap(map);
        }
        return emptyMap();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.Map<K, ? extends V> */
    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    public static final <K, V> Map<K, V> orEmpty(Map<K, ? extends V> map) {
        return map != 0 ? map : emptyMap();
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Pair<? extends K, ? extends V> pair) {
        if (map.isEmpty()) {
            return MapsKt__MapsJVMKt.mapOf(pair);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(pair.getFirst(), pair.getSecond());
        return linkedHashMap;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: K, ? super K */
    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: V, ? super V */
    @InlineOnly
    public static final <K, V> void plusAssign(Map<? super K, ? super V> map, Pair<? extends K, ? extends V> pair) {
        map.put((K) pair.getFirst(), (V) pair.getSecond());
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: V, ? super V */
    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: K, ? super K */
    public static final <K, V> void putAll(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairArr) {
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            map.put((K) pair.component1(), (V) pair.component2());
        }
    }

    @InlineOnly
    public static final <K, V> V remove(Map<? extends K, V> map, K k) {
        if (map != null) {
            return (V) TypeIntrinsics.asMutableMap(map).remove(k);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }

    @InlineOnly
    public static final <K, V> void set(Map<K, V> map, K k, V v) {
        map.put(k, v);
    }

    public static final <K, V> Map<K, V> toMap(Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    return toMap(iterable, new LinkedHashMap(mapCapacity(collection.size())));
                }
                return MapsKt__MapsJVMKt.mapOf(iterable instanceof List ? (Pair<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
            }
            return emptyMap();
        }
        return optimizeReadOnlyMap(toMap(iterable, new LinkedHashMap()));
    }

    @SinceKotlin(version = "1.1")
    public static final <K, V> Map<K, V> toMutableMap(Map<? extends K, ? extends V> map) {
        return new LinkedHashMap(map);
    }

    @InlineOnly
    public static final <K, V> Pair<K, V> toPair(Map.Entry<? extends K, ? extends V> entry) {
        return new Pair<>(entry.getKey(), entry.getValue());
    }

    public static final <K, V> HashMap<K, V> hashMapOf(Pair<? extends K, ? extends V>... pairArr) {
        HashMap<K, V> hashMap = new HashMap<>(mapCapacity(pairArr.length));
        putAll(hashMap, pairArr);
        return hashMap;
    }

    public static final <K, V> LinkedHashMap<K, V> linkedMapOf(Pair<? extends K, ? extends V>... pairArr) {
        return (LinkedHashMap) toMap(pairArr, new LinkedHashMap(mapCapacity(pairArr.length)));
    }

    @InlineOnly
    public static final <K, V> Map<K, V> mapOf() {
        return emptyMap();
    }

    @SinceKotlin(version = "1.1")
    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> map, Iterable<? extends K> iterable) {
        Map mutableMap = toMutableMap(map);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableMap.keySet(), iterable);
        return optimizeReadOnlyMap(mutableMap);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final <K, V> void minusAssign(Map<K, V> map, Iterable<? extends K> iterable) {
        CollectionsKt__MutableCollectionsKt.removeAll(map.keySet(), iterable);
    }

    public static final <K, V> Map<K, V> mutableMapOf(Pair<? extends K, ? extends V>... pairArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity(pairArr.length));
        putAll(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        if (map.isEmpty()) {
            return toMap(iterable);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        putAll(linkedHashMap, iterable);
        return linkedHashMap;
    }

    @InlineOnly
    public static final <K, V> void plusAssign(Map<? super K, ? super V> map, Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        putAll(map, iterable);
    }

    @SinceKotlin(version = "1.1")
    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> map, K[] kArr) {
        Map mutableMap = toMutableMap(map);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableMap.keySet(), kArr);
        return optimizeReadOnlyMap(mutableMap);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final <K, V> void minusAssign(Map<K, V> map, K[] kArr) {
        CollectionsKt__MutableCollectionsKt.removeAll(map.keySet(), kArr);
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Pair<? extends K, ? extends V>[] pairArr) {
        if (map.isEmpty()) {
            return toMap(pairArr);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        putAll(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    @InlineOnly
    public static final <K, V> void plusAssign(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairArr) {
        putAll(map, pairArr);
    }

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: V, ? super V */
    /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: K, ? super K */
    public static final <K, V> void putAll(Map<? super K, ? super V> map, Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        for (Pair<? extends K, ? extends V> pair : iterable) {
            map.put((K) pair.component1(), (V) pair.component2());
        }
    }

    @SinceKotlin(version = "1.1")
    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> map, Sequence<? extends K> sequence) {
        Map mutableMap = toMutableMap(map);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableMap.keySet(), sequence);
        return optimizeReadOnlyMap(mutableMap);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    public static final <K, V> void minusAssign(Map<K, V> map, Sequence<? extends K> sequence) {
        CollectionsKt__MutableCollectionsKt.removeAll(map.keySet(), sequence);
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Sequence<? extends Pair<? extends K, ? extends V>> sequence) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        putAll(linkedHashMap, sequence);
        return optimizeReadOnlyMap(linkedHashMap);
    }

    @InlineOnly
    public static final <K, V> void plusAssign(Map<? super K, ? super V> map, Sequence<? extends Pair<? extends K, ? extends V>> sequence) {
        putAll(map, sequence);
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.Map<K, ? extends V> */
    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    public static final <K, V> void plusAssign(Map<? super K, ? super V> map, Map<K, ? extends V> map2) {
        map.putAll(map2);
    }

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: V, ? super V */
    /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: K, ? super K */
    public static final <K, V> void putAll(Map<? super K, ? super V> map, Sequence<? extends Pair<? extends K, ? extends V>> sequence) {
        for (Pair<? extends K, ? extends V> pair : sequence) {
            map.put((K) pair.component1(), (V) pair.component2());
        }
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Iterable<? extends Pair<? extends K, ? extends V>> iterable, M m) {
        putAll(m, iterable);
        return m;
    }

    public static final <K, V> Map<K, V> toMap(Pair<? extends K, ? extends V>[] pairArr) {
        int length = pairArr.length;
        if (length != 0) {
            if (length != 1) {
                return toMap(pairArr, new LinkedHashMap(mapCapacity(pairArr.length)));
            }
            return MapsKt__MapsJVMKt.mapOf(pairArr[0]);
        }
        return emptyMap();
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Pair<? extends K, ? extends V>[] pairArr, M m) {
        putAll(m, pairArr);
        return m;
    }

    public static final <K, V> Map<K, V> toMap(Sequence<? extends Pair<? extends K, ? extends V>> sequence) {
        return optimizeReadOnlyMap(toMap(sequence, new LinkedHashMap()));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Sequence<? extends Pair<? extends K, ? extends V>> sequence, M m) {
        putAll(m, sequence);
        return m;
    }

    @SinceKotlin(version = "1.1")
    public static final <K, V> Map<K, V> toMap(Map<? extends K, ? extends V> map) {
        int size = map.size();
        if (size != 0) {
            if (size != 1) {
                return toMutableMap(map);
            }
            return MapsKt__MapsJVMKt.toSingletonMap(map);
        }
        return emptyMap();
    }

    @SinceKotlin(version = "1.1")
    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Map<? extends K, ? extends V> map, M m) {
        m.putAll(map);
        return m;
    }
}
