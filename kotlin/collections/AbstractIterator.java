package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0016\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H$¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\u0010\u0010\t\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\nR\u0018\u0010\u0011\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lkotlin/collections/AbstractIterator;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/Iterator;", "Lkotlin/jvm/internal/markers/KMappedMarker;", "", "computeNext", "()V", AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE, "", "hasNext", "()Z", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "()Ljava/lang/Object;", "value", "setNext", "(Ljava/lang/Object;)V", "tryToComputeNext", "nextValue", "Ljava/lang/Object;", "Lkotlin/collections/State;", "state", "Lkotlin/collections/State;", "<init>", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public abstract class AbstractIterator<T> implements Iterator<T>, KMappedMarker {
    public T nextValue;
    public State state = State.NotReady;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[State.Done.ordinal()] = 1;
            $EnumSwitchMapping$0[State.Ready.ordinal()] = 2;
        }
    }

    private final boolean tryToComputeNext() {
        this.state = State.Failed;
        computeNext();
        return this.state == State.Ready;
    }

    public abstract void computeNext();

    public final void done() {
        this.state = State.Done;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.state != State.Failed) {
            int i = WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return tryToComputeNext();
                }
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            this.state = State.NotReady;
            return this.nextValue;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setNext(T t) {
        this.nextValue = t;
        this.state = State.Ready;
    }
}
