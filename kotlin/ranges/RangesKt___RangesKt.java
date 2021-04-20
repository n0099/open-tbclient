package kotlin.ranges;

import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.encrypt.a;
import com.baidu.android.common.others.IStringUtil;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.ranges.CharProgression;
import kotlin.ranges.IntProgression;
import kotlin.ranges.LongProgression;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b2\u001a)\u0010\u0003\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0006\u001a\u0019\u0010\u0003\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0007¢\u0006\u0004\b\u0003\u0010\b\u001a\u0019\u0010\u0003\u001a\u00020\t*\u00020\t2\u0006\u0010\u0002\u001a\u00020\t¢\u0006\u0004\b\u0003\u0010\n\u001a\u0019\u0010\u0003\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000b¢\u0006\u0004\b\u0003\u0010\f\u001a\u0019\u0010\u0003\u001a\u00020\r*\u00020\r2\u0006\u0010\u0002\u001a\u00020\r¢\u0006\u0004\b\u0003\u0010\u000e\u001a\u0019\u0010\u0003\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f¢\u0006\u0004\b\u0003\u0010\u0010\u001a)\u0010\u0012\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0004\b\u0012\u0010\u0004\u001a\u0019\u0010\u0012\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0006\u001a\u0019\u0010\u0012\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\b\u001a\u0019\u0010\u0012\u001a\u00020\t*\u00020\t2\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\n\u001a\u0019\u0010\u0012\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\f\u001a\u0019\u0010\u0012\u001a\u00020\r*\u00020\r2\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u000e\u001a\u0019\u0010\u0012\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0010\u001a5\u0010\u0013\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\b\u0010\u0002\u001a\u0004\u0018\u00018\u00002\b\u0010\u0011\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a1\u0010\u0013\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0007¢\u0006\u0004\b\u0013\u0010\u0017\u001a/\u0010\u0013\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018¢\u0006\u0004\b\u0013\u0010\u0019\u001a!\u0010\u0013\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u001a\u001a!\u0010\u0013\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u001b\u001a!\u0010\u0013\u001a\u00020\t*\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u001c\u001a!\u0010\u0013\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u001d\u001a\u001f\u0010\u0013\u001a\u00020\u000b*\u00020\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018¢\u0006\u0004\b\u0013\u0010\u001e\u001a!\u0010\u0013\u001a\u00020\r*\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u001f\u001a\u001f\u0010\u0013\u001a\u00020\r*\u00020\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0018¢\u0006\u0004\b\u0013\u0010 \u001a!\u0010\u0013\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010!\u001a\u001e\u0010&\u001a\u00020%*\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010#H\u0087\n¢\u0006\u0004\b&\u0010'\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010(\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0004\b)\u0010*\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010(\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b)\u0010+\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010(\u001a\u00020\u000bH\u0087\u0002¢\u0006\u0004\b)\u0010,\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010(\u001a\u00020\rH\u0087\u0002¢\u0006\u0004\b)\u0010-\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010(\u001a\u00020\u000fH\u0087\u0002¢\u0006\u0004\b)\u0010.\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010(\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0004\b/\u00100\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010(\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b/\u0010+\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010(\u001a\u00020\u000bH\u0087\u0002¢\u0006\u0004\b/\u0010,\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010(\u001a\u00020\rH\u0087\u0002¢\u0006\u0004\b/\u0010-\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010(\u001a\u00020\u000fH\u0087\u0002¢\u0006\u0004\b/\u0010.\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\t0\u00182\u0006\u0010(\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0004\b1\u00100\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\t0\u00182\u0006\u0010(\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0004\b1\u0010*\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\t0\u00182\u0006\u0010(\u001a\u00020\u000bH\u0087\u0002¢\u0006\u0004\b1\u0010,\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\t0\u00182\u0006\u0010(\u001a\u00020\rH\u0087\u0002¢\u0006\u0004\b1\u0010-\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\t0\u00182\u0006\u0010(\u001a\u00020\u000fH\u0087\u0002¢\u0006\u0004\b1\u0010.\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u000b0\u00182\u0006\u0010(\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0004\b2\u00100\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u000b0\u00182\u0006\u0010(\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0004\b2\u0010*\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u000b0\u00182\u0006\u0010(\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b2\u0010+\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u000b0\u00182\u0006\u0010(\u001a\u00020\rH\u0087\u0002¢\u0006\u0004\b2\u0010-\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u000b0\u00182\u0006\u0010(\u001a\u00020\u000fH\u0087\u0002¢\u0006\u0004\b2\u0010.\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\r0\u00182\u0006\u0010(\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0004\b3\u00100\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\r0\u00182\u0006\u0010(\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0004\b3\u0010*\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\r0\u00182\u0006\u0010(\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b3\u0010+\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\r0\u00182\u0006\u0010(\u001a\u00020\u000bH\u0087\u0002¢\u0006\u0004\b3\u0010,\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\r0\u00182\u0006\u0010(\u001a\u00020\u000fH\u0087\u0002¢\u0006\u0004\b3\u0010.\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u000f0\u00182\u0006\u0010(\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0004\b4\u00100\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u000f0\u00182\u0006\u0010(\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0004\b4\u0010*\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u000f0\u00182\u0006\u0010(\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b4\u0010+\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u000f0\u00182\u0006\u0010(\u001a\u00020\u000bH\u0087\u0002¢\u0006\u0004\b4\u0010,\u001a\"\u0010&\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u000f0\u00182\u0006\u0010(\u001a\u00020\rH\u0087\u0002¢\u0006\u0004\b4\u0010-\u001a\u001e\u0010&\u001a\u00020%*\u0002052\b\u0010$\u001a\u0004\u0018\u00010\u000bH\u0087\n¢\u0006\u0004\b&\u00106\u001a\u001e\u0010&\u001a\u00020%*\u0002072\b\u0010$\u001a\u0004\u0018\u00010\rH\u0087\n¢\u0006\u0004\b&\u00108\u001a\u001c\u0010;\u001a\u00020:*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0086\u0004¢\u0006\u0004\b;\u0010<\u001a\u001c\u0010;\u001a\u00020:*\u00020\u00052\u0006\u00109\u001a\u00020\u000bH\u0086\u0004¢\u0006\u0004\b;\u0010=\u001a\u001c\u0010;\u001a\u00020>*\u00020\u00052\u0006\u00109\u001a\u00020\rH\u0086\u0004¢\u0006\u0004\b;\u0010?\u001a\u001c\u0010;\u001a\u00020:*\u00020\u00052\u0006\u00109\u001a\u00020\u000fH\u0086\u0004¢\u0006\u0004\b;\u0010@\u001a\u001c\u0010;\u001a\u00020A*\u00020#2\u0006\u00109\u001a\u00020#H\u0086\u0004¢\u0006\u0004\b;\u0010B\u001a\u001c\u0010;\u001a\u00020:*\u00020\u000b2\u0006\u00109\u001a\u00020\u0005H\u0086\u0004¢\u0006\u0004\b;\u0010C\u001a\u001c\u0010;\u001a\u00020:*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0086\u0004¢\u0006\u0004\b;\u0010D\u001a\u001c\u0010;\u001a\u00020>*\u00020\u000b2\u0006\u00109\u001a\u00020\rH\u0086\u0004¢\u0006\u0004\b;\u0010E\u001a\u001c\u0010;\u001a\u00020:*\u00020\u000b2\u0006\u00109\u001a\u00020\u000fH\u0086\u0004¢\u0006\u0004\b;\u0010F\u001a\u001c\u0010;\u001a\u00020>*\u00020\r2\u0006\u00109\u001a\u00020\u0005H\u0086\u0004¢\u0006\u0004\b;\u0010G\u001a\u001c\u0010;\u001a\u00020>*\u00020\r2\u0006\u00109\u001a\u00020\u000bH\u0086\u0004¢\u0006\u0004\b;\u0010H\u001a\u001c\u0010;\u001a\u00020>*\u00020\r2\u0006\u00109\u001a\u00020\rH\u0086\u0004¢\u0006\u0004\b;\u0010I\u001a\u001c\u0010;\u001a\u00020>*\u00020\r2\u0006\u00109\u001a\u00020\u000fH\u0086\u0004¢\u0006\u0004\b;\u0010J\u001a\u001c\u0010;\u001a\u00020:*\u00020\u000f2\u0006\u00109\u001a\u00020\u0005H\u0086\u0004¢\u0006\u0004\b;\u0010K\u001a\u001c\u0010;\u001a\u00020:*\u00020\u000f2\u0006\u00109\u001a\u00020\u000bH\u0086\u0004¢\u0006\u0004\b;\u0010L\u001a\u001c\u0010;\u001a\u00020>*\u00020\u000f2\u0006\u00109\u001a\u00020\rH\u0086\u0004¢\u0006\u0004\b;\u0010M\u001a\u001c\u0010;\u001a\u00020:*\u00020\u000f2\u0006\u00109\u001a\u00020\u000fH\u0086\u0004¢\u0006\u0004\b;\u0010N\u001a\u0014\u0010O\u001a\u00020#*\u00020\"H\u0087\b¢\u0006\u0004\bO\u0010P\u001a\u001b\u0010O\u001a\u00020#*\u00020\"2\u0006\u0010O\u001a\u00020QH\u0007¢\u0006\u0004\bO\u0010R\u001a\u0014\u0010O\u001a\u00020\u000b*\u000205H\u0087\b¢\u0006\u0004\bO\u0010S\u001a\u001b\u0010O\u001a\u00020\u000b*\u0002052\u0006\u0010O\u001a\u00020QH\u0007¢\u0006\u0004\bO\u0010T\u001a\u0014\u0010O\u001a\u00020\r*\u000207H\u0087\b¢\u0006\u0004\bO\u0010U\u001a\u001b\u0010O\u001a\u00020\r*\u0002072\u0006\u0010O\u001a\u00020QH\u0007¢\u0006\u0004\bO\u0010V\u001a\u0011\u0010W\u001a\u00020A*\u00020A¢\u0006\u0004\bW\u0010X\u001a\u0011\u0010W\u001a\u00020:*\u00020:¢\u0006\u0004\bW\u0010Y\u001a\u0011\u0010W\u001a\u00020>*\u00020>¢\u0006\u0004\bW\u0010Z\u001a\u001c\u0010[\u001a\u00020A*\u00020A2\u0006\u0010[\u001a\u00020\u000bH\u0086\u0004¢\u0006\u0004\b[\u0010\\\u001a\u001c\u0010[\u001a\u00020:*\u00020:2\u0006\u0010[\u001a\u00020\u000bH\u0086\u0004¢\u0006\u0004\b[\u0010]\u001a\u001c\u0010[\u001a\u00020>*\u00020>2\u0006\u0010[\u001a\u00020\rH\u0086\u0004¢\u0006\u0004\b[\u0010^\u001a\u0015\u0010_\u001a\u0004\u0018\u00010\u0005*\u00020\u0007H\u0000¢\u0006\u0004\b_\u0010`\u001a\u0015\u0010_\u001a\u0004\u0018\u00010\u0005*\u00020\tH\u0000¢\u0006\u0004\b_\u0010a\u001a\u0015\u0010_\u001a\u0004\u0018\u00010\u0005*\u00020\u000bH\u0000¢\u0006\u0004\b_\u0010b\u001a\u0015\u0010_\u001a\u0004\u0018\u00010\u0005*\u00020\rH\u0000¢\u0006\u0004\b_\u0010c\u001a\u0015\u0010_\u001a\u0004\u0018\u00010\u0005*\u00020\u000fH\u0000¢\u0006\u0004\b_\u0010d\u001a\u0015\u0010e\u001a\u0004\u0018\u00010\u000b*\u00020\u0007H\u0000¢\u0006\u0004\be\u0010f\u001a\u0015\u0010e\u001a\u0004\u0018\u00010\u000b*\u00020\tH\u0000¢\u0006\u0004\be\u0010g\u001a\u0015\u0010e\u001a\u0004\u0018\u00010\u000b*\u00020\rH\u0000¢\u0006\u0004\be\u0010h\u001a\u0015\u0010i\u001a\u0004\u0018\u00010\r*\u00020\u0007H\u0000¢\u0006\u0004\bi\u0010j\u001a\u0015\u0010i\u001a\u0004\u0018\u00010\r*\u00020\tH\u0000¢\u0006\u0004\bi\u0010k\u001a\u0015\u0010l\u001a\u0004\u0018\u00010\u000f*\u00020\u0007H\u0000¢\u0006\u0004\bl\u0010m\u001a\u0015\u0010l\u001a\u0004\u0018\u00010\u000f*\u00020\tH\u0000¢\u0006\u0004\bl\u0010n\u001a\u0015\u0010l\u001a\u0004\u0018\u00010\u000f*\u00020\u000bH\u0000¢\u0006\u0004\bl\u0010o\u001a\u0015\u0010l\u001a\u0004\u0018\u00010\u000f*\u00020\rH\u0000¢\u0006\u0004\bl\u0010p\u001a\u001c\u0010q\u001a\u000205*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0086\u0004¢\u0006\u0004\bq\u0010r\u001a\u001c\u0010q\u001a\u000205*\u00020\u00052\u0006\u00109\u001a\u00020\u000bH\u0086\u0004¢\u0006\u0004\bq\u0010s\u001a\u001c\u0010q\u001a\u000207*\u00020\u00052\u0006\u00109\u001a\u00020\rH\u0086\u0004¢\u0006\u0004\bq\u0010t\u001a\u001c\u0010q\u001a\u000205*\u00020\u00052\u0006\u00109\u001a\u00020\u000fH\u0086\u0004¢\u0006\u0004\bq\u0010u\u001a\u001c\u0010q\u001a\u00020\"*\u00020#2\u0006\u00109\u001a\u00020#H\u0086\u0004¢\u0006\u0004\bq\u0010v\u001a\u001c\u0010q\u001a\u000205*\u00020\u000b2\u0006\u00109\u001a\u00020\u0005H\u0086\u0004¢\u0006\u0004\bq\u0010w\u001a\u001c\u0010q\u001a\u000205*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0086\u0004¢\u0006\u0004\bq\u0010x\u001a\u001c\u0010q\u001a\u000207*\u00020\u000b2\u0006\u00109\u001a\u00020\rH\u0086\u0004¢\u0006\u0004\bq\u0010y\u001a\u001c\u0010q\u001a\u000205*\u00020\u000b2\u0006\u00109\u001a\u00020\u000fH\u0086\u0004¢\u0006\u0004\bq\u0010z\u001a\u001c\u0010q\u001a\u000207*\u00020\r2\u0006\u00109\u001a\u00020\u0005H\u0086\u0004¢\u0006\u0004\bq\u0010{\u001a\u001c\u0010q\u001a\u000207*\u00020\r2\u0006\u00109\u001a\u00020\u000bH\u0086\u0004¢\u0006\u0004\bq\u0010|\u001a\u001c\u0010q\u001a\u000207*\u00020\r2\u0006\u00109\u001a\u00020\rH\u0086\u0004¢\u0006\u0004\bq\u0010}\u001a\u001c\u0010q\u001a\u000207*\u00020\r2\u0006\u00109\u001a\u00020\u000fH\u0086\u0004¢\u0006\u0004\bq\u0010~\u001a\u001c\u0010q\u001a\u000205*\u00020\u000f2\u0006\u00109\u001a\u00020\u0005H\u0086\u0004¢\u0006\u0004\bq\u0010\u007f\u001a\u001d\u0010q\u001a\u000205*\u00020\u000f2\u0006\u00109\u001a\u00020\u000bH\u0086\u0004¢\u0006\u0005\bq\u0010\u0080\u0001\u001a\u001d\u0010q\u001a\u000207*\u00020\u000f2\u0006\u00109\u001a\u00020\rH\u0086\u0004¢\u0006\u0005\bq\u0010\u0081\u0001\u001a\u001d\u0010q\u001a\u000205*\u00020\u000f2\u0006\u00109\u001a\u00020\u000fH\u0086\u0004¢\u0006\u0005\bq\u0010\u0082\u0001¨\u0006\u0083\u0001"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "minimumValue", "coerceAtLeast", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "(BB)B", "", "(DD)D", "", "(FF)F", "", "(II)I", "", "(JJ)J", "", "(SS)S", "maximumValue", "coerceAtMost", "coerceIn", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "Lkotlin/ranges/ClosedFloatingPointRange;", "range", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "Lkotlin/ranges/ClosedRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;)Ljava/lang/Comparable;", "(BBB)B", "(DDD)D", "(FFF)F", "(III)I", "(ILkotlin/ranges/ClosedRange;)I", "(JJJ)J", "(JLkotlin/ranges/ClosedRange;)J", "(SSS)S", "Lkotlin/ranges/CharRange;", "", "element", "", "contains", "(Lkotlin/ranges/CharRange;Ljava/lang/Character;)Z", "value", "byteRangeContains", "(Lkotlin/ranges/ClosedRange;D)Z", "(Lkotlin/ranges/ClosedRange;F)Z", "(Lkotlin/ranges/ClosedRange;I)Z", "(Lkotlin/ranges/ClosedRange;J)Z", "(Lkotlin/ranges/ClosedRange;S)Z", "doubleRangeContains", "(Lkotlin/ranges/ClosedRange;B)Z", "floatRangeContains", "intRangeContains", "longRangeContains", "shortRangeContains", "Lkotlin/ranges/IntRange;", "(Lkotlin/ranges/IntRange;Ljava/lang/Integer;)Z", "Lkotlin/ranges/LongRange;", "(Lkotlin/ranges/LongRange;Ljava/lang/Long;)Z", "to", "Lkotlin/ranges/IntProgression;", "downTo", "(BB)Lkotlin/ranges/IntProgression;", "(BI)Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/LongProgression;", "(BJ)Lkotlin/ranges/LongProgression;", "(BS)Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/CharProgression;", "(CC)Lkotlin/ranges/CharProgression;", "(IB)Lkotlin/ranges/IntProgression;", "(II)Lkotlin/ranges/IntProgression;", "(IJ)Lkotlin/ranges/LongProgression;", "(IS)Lkotlin/ranges/IntProgression;", "(JB)Lkotlin/ranges/LongProgression;", "(JI)Lkotlin/ranges/LongProgression;", "(JJ)Lkotlin/ranges/LongProgression;", "(JS)Lkotlin/ranges/LongProgression;", "(SB)Lkotlin/ranges/IntProgression;", "(SI)Lkotlin/ranges/IntProgression;", "(SJ)Lkotlin/ranges/LongProgression;", "(SS)Lkotlin/ranges/IntProgression;", "random", "(Lkotlin/ranges/CharRange;)C", "Lkotlin/random/Random;", "(Lkotlin/ranges/CharRange;Lkotlin/random/Random;)C", "(Lkotlin/ranges/IntRange;)I", "(Lkotlin/ranges/IntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/LongRange;)J", "(Lkotlin/ranges/LongRange;Lkotlin/random/Random;)J", "reversed", "(Lkotlin/ranges/CharProgression;)Lkotlin/ranges/CharProgression;", "(Lkotlin/ranges/IntProgression;)Lkotlin/ranges/IntProgression;", "(Lkotlin/ranges/LongProgression;)Lkotlin/ranges/LongProgression;", "step", "(Lkotlin/ranges/CharProgression;I)Lkotlin/ranges/CharProgression;", "(Lkotlin/ranges/IntProgression;I)Lkotlin/ranges/IntProgression;", "(Lkotlin/ranges/LongProgression;J)Lkotlin/ranges/LongProgression;", "toByteExactOrNull", "(D)Ljava/lang/Byte;", "(F)Ljava/lang/Byte;", "(I)Ljava/lang/Byte;", "(J)Ljava/lang/Byte;", "(S)Ljava/lang/Byte;", "toIntExactOrNull", "(D)Ljava/lang/Integer;", "(F)Ljava/lang/Integer;", "(J)Ljava/lang/Integer;", "toLongExactOrNull", "(D)Ljava/lang/Long;", "(F)Ljava/lang/Long;", "toShortExactOrNull", "(D)Ljava/lang/Short;", "(F)Ljava/lang/Short;", "(I)Ljava/lang/Short;", "(J)Ljava/lang/Short;", "until", "(BB)Lkotlin/ranges/IntRange;", "(BI)Lkotlin/ranges/IntRange;", "(BJ)Lkotlin/ranges/LongRange;", "(BS)Lkotlin/ranges/IntRange;", "(CC)Lkotlin/ranges/CharRange;", "(IB)Lkotlin/ranges/IntRange;", "(II)Lkotlin/ranges/IntRange;", "(IJ)Lkotlin/ranges/LongRange;", "(IS)Lkotlin/ranges/IntRange;", "(JB)Lkotlin/ranges/LongRange;", "(JI)Lkotlin/ranges/LongRange;", "(JJ)Lkotlin/ranges/LongRange;", "(JS)Lkotlin/ranges/LongRange;", "(SB)Lkotlin/ranges/IntRange;", "(SI)Lkotlin/ranges/IntRange;", "(SJ)Lkotlin/ranges/LongRange;", "(SS)Lkotlin/ranges/IntRange;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 15}, pn = "", xi = 0, xs = "kotlin/ranges/RangesKt")
/* loaded from: classes7.dex */
public class RangesKt___RangesKt extends RangesKt__RangesKt {
    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(ClosedRange<Byte> closedRange, double d2) {
        Byte byteExactOrNull = toByteExactOrNull(d2);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final byte coerceAtLeast(byte b2, byte b3) {
        return b2 < b3 ? b3 : b2;
    }

    public static final double coerceAtLeast(double d2, double d3) {
        return d2 < d3 ? d3 : d2;
    }

    public static final float coerceAtLeast(float f2, float f3) {
        return f2 < f3 ? f3 : f2;
    }

    public static final int coerceAtLeast(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static final long coerceAtLeast(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    public static final <T extends Comparable<? super T>> T coerceAtLeast(T t, T t2) {
        return t.compareTo(t2) < 0 ? t2 : t;
    }

    public static final short coerceAtLeast(short s, short s2) {
        return s < s2 ? s2 : s;
    }

    public static final byte coerceAtMost(byte b2, byte b3) {
        return b2 > b3 ? b3 : b2;
    }

    public static final double coerceAtMost(double d2, double d3) {
        return d2 > d3 ? d3 : d2;
    }

    public static final float coerceAtMost(float f2, float f3) {
        return f2 > f3 ? f3 : f2;
    }

    public static final int coerceAtMost(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static final long coerceAtMost(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    public static final <T extends Comparable<? super T>> T coerceAtMost(T t, T t2) {
        return t.compareTo(t2) > 0 ? t2 : t;
    }

    public static final short coerceAtMost(short s, short s2) {
        return s > s2 ? s2 : s;
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T t, T t2, T t3) {
        if (t2 != null && t3 != null) {
            if (t2.compareTo(t3) <= 0) {
                if (t.compareTo(t2) < 0) {
                    return t2;
                }
                if (t.compareTo(t3) > 0) {
                    return t3;
                }
            } else {
                throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + t3 + " is less than minimum " + t2 + IStringUtil.EXTENSION_SEPARATOR);
            }
        } else if (t2 != null && t.compareTo(t2) < 0) {
            return t2;
        } else {
            if (t3 != null && t.compareTo(t3) > 0) {
                return t3;
            }
        }
        return t;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final boolean contains(IntRange intRange, Integer num) {
        return num != null && intRange.contains(num.intValue());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "doubleRangeContains")
    public static final boolean doubleRangeContains(ClosedRange<Double> closedRange, byte b2) {
        return closedRange.contains(Double.valueOf(b2));
    }

    public static final IntProgression downTo(int i, byte b2) {
        return IntProgression.Companion.fromClosedRange(i, b2, -1);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "floatRangeContains")
    public static final boolean floatRangeContains(ClosedRange<Float> closedRange, byte b2) {
        return closedRange.contains(Float.valueOf(b2));
    }

    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(ClosedRange<Integer> closedRange, byte b2) {
        return closedRange.contains(Integer.valueOf(b2));
    }

    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(ClosedRange<Long> closedRange, byte b2) {
        return closedRange.contains(Long.valueOf(b2));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final int random(IntRange intRange) {
        return random(intRange, Random.Default);
    }

    public static final IntProgression reversed(IntProgression intProgression) {
        return IntProgression.Companion.fromClosedRange(intProgression.getLast(), intProgression.getFirst(), -intProgression.getStep());
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(ClosedRange<Short> closedRange, byte b2) {
        return closedRange.contains(Short.valueOf(b2));
    }

    public static final IntProgression step(IntProgression intProgression, int i) {
        RangesKt__RangesKt.checkStepIsPositive(i > 0, Integer.valueOf(i));
        IntProgression.Companion companion = IntProgression.Companion;
        int first = intProgression.getFirst();
        int last = intProgression.getLast();
        if (intProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.fromClosedRange(first, last, i);
    }

    public static final Byte toByteExactOrNull(int i) {
        if (-128 <= i && 127 >= i) {
            return Byte.valueOf((byte) i);
        }
        return null;
    }

    public static final Integer toIntExactOrNull(long j) {
        long j2 = Integer.MAX_VALUE;
        if (Integer.MIN_VALUE <= j && j2 >= j) {
            return Integer.valueOf((int) j);
        }
        return null;
    }

    public static final Long toLongExactOrNull(double d2) {
        double d3 = Long.MAX_VALUE;
        if (d2 < Long.MIN_VALUE || d2 > d3) {
            return null;
        }
        return Long.valueOf((long) d2);
    }

    public static final Short toShortExactOrNull(int i) {
        if (-32768 <= i && 32767 >= i) {
            return Short.valueOf((short) i);
        }
        return null;
    }

    public static final IntRange until(int i, byte b2) {
        return new IntRange(i, b2 - 1);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(ClosedRange<Byte> closedRange, float f2) {
        Byte byteExactOrNull = toByteExactOrNull(f2);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final boolean contains(LongRange longRange, Long l) {
        return l != null && longRange.contains(l.longValue());
    }

    @JvmName(name = "doubleRangeContains")
    public static final boolean doubleRangeContains(ClosedRange<Double> closedRange, float f2) {
        return closedRange.contains(Double.valueOf(f2));
    }

    public static final LongProgression downTo(long j, byte b2) {
        return LongProgression.Companion.fromClosedRange(j, b2, -1L);
    }

    @JvmName(name = "floatRangeContains")
    public static final boolean floatRangeContains(ClosedRange<Float> closedRange, double d2) {
        return closedRange.contains(Float.valueOf((float) d2));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(ClosedRange<Integer> closedRange, double d2) {
        Integer intExactOrNull = toIntExactOrNull(d2);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(ClosedRange<Long> closedRange, double d2) {
        Long longExactOrNull = toLongExactOrNull(d2);
        if (longExactOrNull != null) {
            return closedRange.contains(longExactOrNull);
        }
        return false;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final long random(LongRange longRange) {
        return random(longRange, Random.Default);
    }

    public static final LongProgression reversed(LongProgression longProgression) {
        return LongProgression.Companion.fromClosedRange(longProgression.getLast(), longProgression.getFirst(), -longProgression.getStep());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(ClosedRange<Short> closedRange, double d2) {
        Short shortExactOrNull = toShortExactOrNull(d2);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    public static final Byte toByteExactOrNull(long j) {
        long j2 = 127;
        if (((long) a.f1921g) <= j && j2 >= j) {
            return Byte.valueOf((byte) j);
        }
        return null;
    }

    public static final Integer toIntExactOrNull(double d2) {
        double d3 = Integer.MAX_VALUE;
        if (d2 < Integer.MIN_VALUE || d2 > d3) {
            return null;
        }
        return Integer.valueOf((int) d2);
    }

    public static final Long toLongExactOrNull(float f2) {
        float f3 = (float) Long.MAX_VALUE;
        if (f2 < ((float) Long.MIN_VALUE) || f2 > f3) {
            return null;
        }
        return Long.valueOf(f2);
    }

    public static final Short toShortExactOrNull(long j) {
        long j2 = 32767;
        if (-32768 <= j && j2 >= j) {
            return Short.valueOf((short) j);
        }
        return null;
    }

    public static final LongRange until(long j, byte b2) {
        return new LongRange(j, b2 - 1);
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(ClosedRange<Byte> closedRange, int i) {
        Byte byteExactOrNull = toByteExactOrNull(i);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final boolean contains(CharRange charRange, Character ch) {
        return ch != null && charRange.contains(ch.charValue());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "doubleRangeContains")
    public static final boolean doubleRangeContains(ClosedRange<Double> closedRange, int i) {
        return closedRange.contains(Double.valueOf(i));
    }

    public static final IntProgression downTo(byte b2, byte b3) {
        return IntProgression.Companion.fromClosedRange(b2, b3, -1);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "floatRangeContains")
    public static final boolean floatRangeContains(ClosedRange<Float> closedRange, int i) {
        return closedRange.contains(Float.valueOf(i));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(ClosedRange<Integer> closedRange, float f2) {
        Integer intExactOrNull = toIntExactOrNull(f2);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(ClosedRange<Long> closedRange, float f2) {
        Long longExactOrNull = toLongExactOrNull(f2);
        if (longExactOrNull != null) {
            return closedRange.contains(longExactOrNull);
        }
        return false;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static final char random(CharRange charRange) {
        return random(charRange, Random.Default);
    }

    public static final CharProgression reversed(CharProgression charProgression) {
        return CharProgression.Companion.fromClosedRange(charProgression.getLast(), charProgression.getFirst(), -charProgression.getStep());
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(ClosedRange<Short> closedRange, float f2) {
        Short shortExactOrNull = toShortExactOrNull(f2);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    public static final LongProgression step(LongProgression longProgression, long j) {
        RangesKt__RangesKt.checkStepIsPositive(j > 0, Long.valueOf(j));
        LongProgression.Companion companion = LongProgression.Companion;
        long first = longProgression.getFirst();
        long last = longProgression.getLast();
        if (longProgression.getStep() <= 0) {
            j = -j;
        }
        return companion.fromClosedRange(first, last, j);
    }

    public static final Byte toByteExactOrNull(short s) {
        short s2 = (short) 127;
        if (((short) a.f1921g) <= s && s2 >= s) {
            return Byte.valueOf((byte) s);
        }
        return null;
    }

    public static final Integer toIntExactOrNull(float f2) {
        float f3 = Integer.MAX_VALUE;
        if (f2 < Integer.MIN_VALUE || f2 > f3) {
            return null;
        }
        return Integer.valueOf((int) f2);
    }

    public static final Short toShortExactOrNull(double d2) {
        double d3 = 32767;
        if (d2 < -32768 || d2 > d3) {
            return null;
        }
        return Short.valueOf((short) d2);
    }

    public static final IntRange until(byte b2, byte b3) {
        return new IntRange(b2, b3 - 1);
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(ClosedRange<Byte> closedRange, long j) {
        Byte byteExactOrNull = toByteExactOrNull(j);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "doubleRangeContains")
    public static final boolean doubleRangeContains(ClosedRange<Double> closedRange, long j) {
        return closedRange.contains(Double.valueOf(j));
    }

    public static final IntProgression downTo(short s, byte b2) {
        return IntProgression.Companion.fromClosedRange(s, b2, -1);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "floatRangeContains")
    public static final boolean floatRangeContains(ClosedRange<Float> closedRange, long j) {
        return closedRange.contains(Float.valueOf((float) j));
    }

    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(ClosedRange<Integer> closedRange, long j) {
        Integer intExactOrNull = toIntExactOrNull(j);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(ClosedRange<Long> closedRange, int i) {
        return closedRange.contains(Long.valueOf(i));
    }

    @SinceKotlin(version = "1.3")
    public static final int random(IntRange intRange, Random random) {
        try {
            return RandomKt.nextInt(random, intRange);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(ClosedRange<Short> closedRange, int i) {
        Short shortExactOrNull = toShortExactOrNull(i);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    public static final Byte toByteExactOrNull(double d2) {
        double d3 = 127;
        if (d2 < ((double) a.f1921g) || d2 > d3) {
            return null;
        }
        return Byte.valueOf((byte) d2);
    }

    public static final Short toShortExactOrNull(float f2) {
        float f3 = 32767;
        if (f2 < -32768 || f2 > f3) {
            return null;
        }
        return Short.valueOf((short) f2);
    }

    public static final IntRange until(short s, byte b2) {
        return new IntRange(s, b2 - 1);
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(ClosedRange<Byte> closedRange, short s) {
        Byte byteExactOrNull = toByteExactOrNull(s);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "doubleRangeContains")
    public static final boolean doubleRangeContains(ClosedRange<Double> closedRange, short s) {
        return closedRange.contains(Double.valueOf(s));
    }

    public static final CharProgression downTo(char c2, char c3) {
        return CharProgression.Companion.fromClosedRange(c2, c3, -1);
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @JvmName(name = "floatRangeContains")
    public static final boolean floatRangeContains(ClosedRange<Float> closedRange, short s) {
        return closedRange.contains(Float.valueOf(s));
    }

    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(ClosedRange<Integer> closedRange, short s) {
        return closedRange.contains(Integer.valueOf(s));
    }

    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(ClosedRange<Long> closedRange, short s) {
        return closedRange.contains(Long.valueOf(s));
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(ClosedRange<Short> closedRange, long j) {
        Short shortExactOrNull = toShortExactOrNull(j);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    public static final CharProgression step(CharProgression charProgression, int i) {
        RangesKt__RangesKt.checkStepIsPositive(i > 0, Integer.valueOf(i));
        CharProgression.Companion companion = CharProgression.Companion;
        char first = charProgression.getFirst();
        char last = charProgression.getLast();
        if (charProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.fromClosedRange(first, last, i);
    }

    public static final Byte toByteExactOrNull(float f2) {
        float f3 = 127;
        if (f2 < ((float) a.f1921g) || f2 > f3) {
            return null;
        }
        return Byte.valueOf((byte) f2);
    }

    public static final CharRange until(char c2, char c3) {
        if (c3 <= 0) {
            return CharRange.Companion.getEMPTY();
        }
        return new CharRange(c2, (char) (c3 - 1));
    }

    public static final IntProgression downTo(int i, int i2) {
        return IntProgression.Companion.fromClosedRange(i, i2, -1);
    }

    @SinceKotlin(version = "1.3")
    public static final long random(LongRange longRange, Random random) {
        try {
            return RandomKt.nextLong(random, longRange);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    public static final byte coerceIn(byte b2, byte b3, byte b4) {
        if (b3 <= b4) {
            return b2 < b3 ? b3 : b2 > b4 ? b4 : b2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) b4) + " is less than minimum " + ((int) b3) + IStringUtil.EXTENSION_SEPARATOR);
    }

    public static final LongProgression downTo(long j, int i) {
        return LongProgression.Companion.fromClosedRange(j, i, -1L);
    }

    public static final IntRange until(int i, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return IntRange.Companion.getEMPTY();
        }
        return new IntRange(i, i2 - 1);
    }

    public static final short coerceIn(short s, short s2, short s3) {
        if (s2 <= s3) {
            return s < s2 ? s2 : s > s3 ? s3 : s;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) s3) + " is less than minimum " + ((int) s2) + IStringUtil.EXTENSION_SEPARATOR);
    }

    public static final IntProgression downTo(byte b2, int i) {
        return IntProgression.Companion.fromClosedRange(b2, i, -1);
    }

    @SinceKotlin(version = "1.3")
    public static final char random(CharRange charRange, Random random) {
        try {
            return (char) random.nextInt(charRange.getFirst(), charRange.getLast() + 1);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    public static final int coerceIn(int i, int i2, int i3) {
        if (i2 <= i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + IStringUtil.EXTENSION_SEPARATOR);
    }

    public static final IntProgression downTo(short s, int i) {
        return IntProgression.Companion.fromClosedRange(s, i, -1);
    }

    public static final LongRange until(long j, int i) {
        return new LongRange(j, i - 1);
    }

    public static final long coerceIn(long j, long j2, long j3) {
        if (j2 <= j3) {
            return j < j2 ? j2 : j > j3 ? j3 : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j3 + " is less than minimum " + j2 + IStringUtil.EXTENSION_SEPARATOR);
    }

    public static final LongProgression downTo(int i, long j) {
        return LongProgression.Companion.fromClosedRange(i, j, -1L);
    }

    public static final IntRange until(byte b2, int i) {
        if (i <= Integer.MIN_VALUE) {
            return IntRange.Companion.getEMPTY();
        }
        return new IntRange(b2, i - 1);
    }

    public static final float coerceIn(float f2, float f3, float f4) {
        if (f3 <= f4) {
            return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f4 + " is less than minimum " + f3 + IStringUtil.EXTENSION_SEPARATOR);
    }

    public static final LongProgression downTo(long j, long j2) {
        return LongProgression.Companion.fromClosedRange(j, j2, -1L);
    }

    public static final double coerceIn(double d2, double d3, double d4) {
        if (d3 <= d4) {
            return d2 < d3 ? d3 : d2 > d4 ? d4 : d2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d4 + " is less than minimum " + d3 + IStringUtil.EXTENSION_SEPARATOR);
    }

    public static final LongProgression downTo(byte b2, long j) {
        return LongProgression.Companion.fromClosedRange(b2, j, -1L);
    }

    public static final IntRange until(short s, int i) {
        if (i <= Integer.MIN_VALUE) {
            return IntRange.Companion.getEMPTY();
        }
        return new IntRange(s, i - 1);
    }

    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T coerceIn(T t, ClosedFloatingPointRange<T> closedFloatingPointRange) {
        if (!closedFloatingPointRange.isEmpty()) {
            return (!closedFloatingPointRange.lessThanOrEquals(t, closedFloatingPointRange.getStart()) || closedFloatingPointRange.lessThanOrEquals(closedFloatingPointRange.getStart(), t)) ? (!closedFloatingPointRange.lessThanOrEquals(closedFloatingPointRange.getEndInclusive(), t) || closedFloatingPointRange.lessThanOrEquals(t, closedFloatingPointRange.getEndInclusive())) ? t : closedFloatingPointRange.getEndInclusive() : closedFloatingPointRange.getStart();
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedFloatingPointRange + IStringUtil.EXTENSION_SEPARATOR);
    }

    public static final LongProgression downTo(short s, long j) {
        return LongProgression.Companion.fromClosedRange(s, j, -1L);
    }

    public static final IntProgression downTo(int i, short s) {
        return IntProgression.Companion.fromClosedRange(i, s, -1);
    }

    public static final LongRange until(int i, long j) {
        if (j <= Long.MIN_VALUE) {
            return LongRange.Companion.getEMPTY();
        }
        return new LongRange(i, j - 1);
    }

    public static final LongProgression downTo(long j, short s) {
        return LongProgression.Companion.fromClosedRange(j, s, -1L);
    }

    public static final IntProgression downTo(byte b2, short s) {
        return IntProgression.Companion.fromClosedRange(b2, s, -1);
    }

    public static final LongRange until(long j, long j2) {
        if (j2 <= Long.MIN_VALUE) {
            return LongRange.Companion.getEMPTY();
        }
        return new LongRange(j, j2 - 1);
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T t, ClosedRange<T> closedRange) {
        if (closedRange instanceof ClosedFloatingPointRange) {
            return (T) coerceIn((Comparable) t, (ClosedFloatingPointRange) closedRange);
        }
        if (!closedRange.isEmpty()) {
            return t.compareTo(closedRange.getStart()) < 0 ? closedRange.getStart() : t.compareTo(closedRange.getEndInclusive()) > 0 ? closedRange.getEndInclusive() : t;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedRange + IStringUtil.EXTENSION_SEPARATOR);
    }

    public static final IntProgression downTo(short s, short s2) {
        return IntProgression.Companion.fromClosedRange(s, s2, -1);
    }

    public static final LongRange until(byte b2, long j) {
        if (j <= Long.MIN_VALUE) {
            return LongRange.Companion.getEMPTY();
        }
        return new LongRange(b2, j - 1);
    }

    public static final LongRange until(short s, long j) {
        if (j <= Long.MIN_VALUE) {
            return LongRange.Companion.getEMPTY();
        }
        return new LongRange(s, j - 1);
    }

    public static final IntRange until(int i, short s) {
        return new IntRange(i, s - 1);
    }

    public static final int coerceIn(int i, ClosedRange<Integer> closedRange) {
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((Number) coerceIn(Integer.valueOf(i), (ClosedFloatingPointRange<Integer>) closedRange)).intValue();
        }
        if (!closedRange.isEmpty()) {
            return i < closedRange.getStart().intValue() ? closedRange.getStart().intValue() : i > closedRange.getEndInclusive().intValue() ? closedRange.getEndInclusive().intValue() : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedRange + IStringUtil.EXTENSION_SEPARATOR);
    }

    public static final LongRange until(long j, short s) {
        return new LongRange(j, s - 1);
    }

    public static final IntRange until(byte b2, short s) {
        return new IntRange(b2, s - 1);
    }

    public static final IntRange until(short s, short s2) {
        return new IntRange(s, s2 - 1);
    }

    public static final long coerceIn(long j, ClosedRange<Long> closedRange) {
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((Number) coerceIn(Long.valueOf(j), (ClosedFloatingPointRange<Long>) closedRange)).longValue();
        }
        if (!closedRange.isEmpty()) {
            return j < closedRange.getStart().longValue() ? closedRange.getStart().longValue() : j > closedRange.getEndInclusive().longValue() ? closedRange.getEndInclusive().longValue() : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedRange + IStringUtil.EXTENSION_SEPARATOR);
    }
}
