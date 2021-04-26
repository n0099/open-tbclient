package io.flutter.embedding.android;

import android.os.Build;
import android.view.InputDevice;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes7.dex */
public class AndroidTouchProcessor {
    public static final int BYTES_PER_FIELD = 8;
    public static final int POINTER_DATA_FIELD_COUNT = 28;
    public static final int POINTER_DATA_FLAG_BATCHED = 1;
    public static final int _POINTER_BUTTON_PRIMARY = 1;
    @NonNull
    public final FlutterRenderer renderer;

    /* loaded from: classes7.dex */
    public @interface PointerChange {
        public static final int ADD = 1;
        public static final int CANCEL = 0;
        public static final int DOWN = 4;
        public static final int HOVER = 3;
        public static final int MOVE = 5;
        public static final int REMOVE = 2;
        public static final int UP = 6;
    }

    /* loaded from: classes7.dex */
    public @interface PointerDeviceKind {
        public static final int INVERTED_STYLUS = 3;
        public static final int MOUSE = 1;
        public static final int STYLUS = 2;
        public static final int TOUCH = 0;
        public static final int UNKNOWN = 4;
    }

    /* loaded from: classes7.dex */
    public @interface PointerSignalKind {
        public static final int NONE = 0;
        public static final int SCROLL = 1;
        public static final int UNKNOWN = 2;
    }

    public AndroidTouchProcessor(@NonNull FlutterRenderer flutterRenderer) {
        this.renderer = flutterRenderer;
    }

    private void addPointerForIndex(MotionEvent motionEvent, int i2, int i3, int i4, ByteBuffer byteBuffer) {
        long j;
        double d2;
        double d3;
        InputDevice.MotionRange motionRange;
        if (i3 == -1) {
            return;
        }
        int pointerDeviceTypeForToolType = getPointerDeviceTypeForToolType(motionEvent.getToolType(i2));
        int i5 = motionEvent.getActionMasked() == 8 ? 1 : 0;
        byteBuffer.putLong(motionEvent.getEventTime() * 1000);
        byteBuffer.putLong(i3);
        byteBuffer.putLong(pointerDeviceTypeForToolType);
        byteBuffer.putLong(i5);
        byteBuffer.putLong(motionEvent.getPointerId(i2));
        byteBuffer.putLong(0L);
        byteBuffer.putDouble(motionEvent.getX(i2));
        byteBuffer.putDouble(motionEvent.getY(i2));
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(0.0d);
        if (pointerDeviceTypeForToolType == 1) {
            j = motionEvent.getButtonState() & 31;
            if (j == 0 && motionEvent.getSource() == 8194 && (i3 == 4 || i3 == 5)) {
                j = 1;
            }
        } else {
            j = pointerDeviceTypeForToolType == 2 ? (motionEvent.getButtonState() >> 4) & 15 : 0L;
        }
        byteBuffer.putLong(j);
        byteBuffer.putLong(0L);
        byteBuffer.putLong(0L);
        byteBuffer.putDouble(motionEvent.getPressure(i2));
        double d4 = 1.0d;
        if (motionEvent.getDevice() == null || (motionRange = motionEvent.getDevice().getMotionRange(2)) == null) {
            d2 = 0.0d;
        } else {
            double min = motionRange.getMin();
            d4 = motionRange.getMax();
            d2 = min;
        }
        byteBuffer.putDouble(d2);
        byteBuffer.putDouble(d4);
        if (pointerDeviceTypeForToolType == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(24, i2));
            d3 = 0.0d;
            byteBuffer.putDouble(0.0d);
        } else {
            d3 = 0.0d;
            byteBuffer.putDouble(0.0d);
            byteBuffer.putDouble(0.0d);
        }
        byteBuffer.putDouble(motionEvent.getSize(i2));
        byteBuffer.putDouble(motionEvent.getToolMajor(i2));
        byteBuffer.putDouble(motionEvent.getToolMinor(i2));
        byteBuffer.putDouble(d3);
        byteBuffer.putDouble(d3);
        byteBuffer.putDouble(motionEvent.getAxisValue(8, i2));
        if (pointerDeviceTypeForToolType == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(25, i2));
        } else {
            byteBuffer.putDouble(d3);
        }
        byteBuffer.putLong(i4);
        if (i5 == 1) {
            byteBuffer.putDouble(-motionEvent.getAxisValue(10));
            byteBuffer.putDouble(-motionEvent.getAxisValue(9));
            return;
        }
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(0.0d);
    }

    @PointerChange
    private int getPointerChangeForAction(int i2) {
        if (i2 == 0) {
            return 4;
        }
        if (i2 == 1) {
            return 6;
        }
        if (i2 == 5) {
            return 4;
        }
        if (i2 == 6) {
            return 6;
        }
        if (i2 == 2) {
            return 5;
        }
        if (i2 == 7) {
            return 3;
        }
        if (i2 == 3) {
            return 0;
        }
        return i2 == 8 ? 3 : -1;
    }

    @PointerDeviceKind
    private int getPointerDeviceTypeForToolType(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return i2 != 4 ? 4 : 3;
                }
                return 1;
            }
            return 2;
        }
        return 0;
    }

    public boolean onGenericMotionEvent(@NonNull MotionEvent motionEvent) {
        boolean z = Build.VERSION.SDK_INT >= 18 && motionEvent.isFromSource(2);
        boolean z2 = motionEvent.getActionMasked() == 7 || motionEvent.getActionMasked() == 8;
        if (z && z2) {
            int pointerChangeForAction = getPointerChangeForAction(motionEvent.getActionMasked());
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(motionEvent.getPointerCount() * 28 * 8);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            addPointerForIndex(motionEvent, motionEvent.getActionIndex(), pointerChangeForAction, 0, allocateDirect);
            if (allocateDirect.position() % 224 == 0) {
                this.renderer.dispatchPointerDataPacket(allocateDirect, allocateDirect.position());
                return true;
            }
            throw new AssertionError("Packet position is not on field boundary.");
        }
        return false;
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(pointerCount * 28 * 8);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        int actionMasked = motionEvent.getActionMasked();
        int pointerChangeForAction = getPointerChangeForAction(motionEvent.getActionMasked());
        boolean z = actionMasked == 0 || actionMasked == 5;
        boolean z2 = !z && (actionMasked == 1 || actionMasked == 6);
        if (z) {
            addPointerForIndex(motionEvent, motionEvent.getActionIndex(), pointerChangeForAction, 0, allocateDirect);
        } else if (z2) {
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (i2 != motionEvent.getActionIndex() && motionEvent.getToolType(i2) == 1) {
                    addPointerForIndex(motionEvent, i2, 5, 1, allocateDirect);
                }
            }
            addPointerForIndex(motionEvent, motionEvent.getActionIndex(), pointerChangeForAction, 0, allocateDirect);
        } else {
            for (int i3 = 0; i3 < pointerCount; i3++) {
                addPointerForIndex(motionEvent, i3, pointerChangeForAction, 0, allocateDirect);
            }
        }
        if (allocateDirect.position() % 224 == 0) {
            this.renderer.dispatchPointerDataPacket(allocateDirect, allocateDirect.position());
            return true;
        }
        throw new AssertionError("Packet position is not on field boundary");
    }
}
