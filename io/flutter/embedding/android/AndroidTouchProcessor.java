package io.flutter.embedding.android;

import android.os.Build;
import android.view.InputDevice;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
public class AndroidTouchProcessor {
    private static final int BYTES_PER_FIELD = 8;
    private static final int POINTER_DATA_FIELD_COUNT = 28;
    private static final int POINTER_DATA_FLAG_BATCHED = 1;
    private static final int _POINTER_BUTTON_PRIMARY = 1;
    @NonNull
    private final FlutterRenderer renderer;

    /* loaded from: classes6.dex */
    private @interface PointerChange {
        public static final int ADD = 1;
        public static final int CANCEL = 0;
        public static final int DOWN = 4;
        public static final int HOVER = 3;
        public static final int MOVE = 5;
        public static final int REMOVE = 2;
        public static final int UP = 6;
    }

    /* loaded from: classes6.dex */
    private @interface PointerDeviceKind {
        public static final int INVERTED_STYLUS = 3;
        public static final int MOUSE = 1;
        public static final int STYLUS = 2;
        public static final int TOUCH = 0;
        public static final int UNKNOWN = 4;
    }

    /* loaded from: classes6.dex */
    private @interface PointerSignalKind {
        public static final int NONE = 0;
        public static final int SCROLL = 1;
        public static final int UNKNOWN = 2;
    }

    public AndroidTouchProcessor(@NonNull FlutterRenderer flutterRenderer) {
        this.renderer = flutterRenderer;
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
            for (int i = 0; i < pointerCount; i++) {
                if (i != motionEvent.getActionIndex() && motionEvent.getToolType(i) == 1) {
                    addPointerForIndex(motionEvent, i, 5, 1, allocateDirect);
                }
            }
            addPointerForIndex(motionEvent, motionEvent.getActionIndex(), pointerChangeForAction, 0, allocateDirect);
        } else {
            for (int i2 = 0; i2 < pointerCount; i2++) {
                addPointerForIndex(motionEvent, i2, pointerChangeForAction, 0, allocateDirect);
            }
        }
        if (allocateDirect.position() % 224 != 0) {
            throw new AssertionError("Packet position is not on field boundary");
        }
        this.renderer.dispatchPointerDataPacket(allocateDirect, allocateDirect.position());
        return true;
    }

    public boolean onGenericMotionEvent(@NonNull MotionEvent motionEvent) {
        boolean z = Build.VERSION.SDK_INT >= 18 && motionEvent.isFromSource(2);
        boolean z2 = motionEvent.getActionMasked() == 7 || motionEvent.getActionMasked() == 8;
        if (z && z2) {
            int pointerChangeForAction = getPointerChangeForAction(motionEvent.getActionMasked());
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(motionEvent.getPointerCount() * 28 * 8);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            addPointerForIndex(motionEvent, motionEvent.getActionIndex(), pointerChangeForAction, 0, allocateDirect);
            if (allocateDirect.position() % 224 != 0) {
                throw new AssertionError("Packet position is not on field boundary.");
            }
            this.renderer.dispatchPointerDataPacket(allocateDirect, allocateDirect.position());
            return true;
        }
        return false;
    }

    private void addPointerForIndex(MotionEvent motionEvent, int i, int i2, int i3, ByteBuffer byteBuffer) {
        long j;
        InputDevice.MotionRange motionRange;
        if (i2 != -1) {
            int pointerDeviceTypeForToolType = getPointerDeviceTypeForToolType(motionEvent.getToolType(i));
            int i4 = motionEvent.getActionMasked() == 8 ? 1 : 0;
            byteBuffer.putLong(motionEvent.getEventTime() * 1000);
            byteBuffer.putLong(i2);
            byteBuffer.putLong(pointerDeviceTypeForToolType);
            byteBuffer.putLong(i4);
            byteBuffer.putLong(motionEvent.getPointerId(i));
            byteBuffer.putLong(0L);
            byteBuffer.putDouble(motionEvent.getX(i));
            byteBuffer.putDouble(motionEvent.getY(i));
            byteBuffer.putDouble(0.0d);
            byteBuffer.putDouble(0.0d);
            if (pointerDeviceTypeForToolType == 1) {
                j = motionEvent.getButtonState() & 31;
                if (j == 0 && motionEvent.getSource() == 8194 && (i2 == 4 || i2 == 5)) {
                    j = 1;
                }
            } else {
                j = pointerDeviceTypeForToolType == 2 ? (motionEvent.getButtonState() >> 4) & 15 : 0L;
            }
            byteBuffer.putLong(j);
            byteBuffer.putLong(0L);
            byteBuffer.putLong(0L);
            byteBuffer.putDouble(motionEvent.getPressure(i));
            double d = 0.0d;
            double d2 = 1.0d;
            if (motionEvent.getDevice() != null && (motionRange = motionEvent.getDevice().getMotionRange(2)) != null) {
                d = motionRange.getMin();
                d2 = motionRange.getMax();
            }
            byteBuffer.putDouble(d);
            byteBuffer.putDouble(d2);
            if (pointerDeviceTypeForToolType == 2) {
                byteBuffer.putDouble(motionEvent.getAxisValue(24, i));
                byteBuffer.putDouble(0.0d);
            } else {
                byteBuffer.putDouble(0.0d);
                byteBuffer.putDouble(0.0d);
            }
            byteBuffer.putDouble(motionEvent.getSize(i));
            byteBuffer.putDouble(motionEvent.getToolMajor(i));
            byteBuffer.putDouble(motionEvent.getToolMinor(i));
            byteBuffer.putDouble(0.0d);
            byteBuffer.putDouble(0.0d);
            byteBuffer.putDouble(motionEvent.getAxisValue(8, i));
            if (pointerDeviceTypeForToolType == 2) {
                byteBuffer.putDouble(motionEvent.getAxisValue(25, i));
            } else {
                byteBuffer.putDouble(0.0d);
            }
            byteBuffer.putLong(i3);
            if (i4 == 1) {
                byteBuffer.putDouble(-motionEvent.getAxisValue(10));
                byteBuffer.putDouble(-motionEvent.getAxisValue(9));
                return;
            }
            byteBuffer.putDouble(0.0d);
            byteBuffer.putDouble(0.0d);
        }
    }

    @PointerChange
    private int getPointerChangeForAction(int i) {
        if (i == 0) {
            return 4;
        }
        if (i == 1) {
            return 6;
        }
        if (i != 5) {
            if (i == 6) {
                return 6;
            }
            if (i == 2) {
                return 5;
            }
            if (i == 7) {
                return 3;
            }
            if (i == 3) {
                return 0;
            }
            return i == 8 ? 3 : -1;
        }
        return 4;
    }

    @PointerDeviceKind
    private int getPointerDeviceTypeForToolType(int i) {
        switch (i) {
            case 1:
                return 0;
            case 2:
                return 2;
            case 3:
                return 1;
            case 4:
                return 3;
            default:
                return 4;
        }
    }
}
