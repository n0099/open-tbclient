package tv.chushou.zues.widget.a;

import android.text.Layout;
import android.text.NoCopySpan;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;
/* loaded from: classes6.dex */
public class b extends ScrollingMovementMethod {
    private static b par;
    private static Object pas = new NoCopySpan.Concrete();
    private boolean paq = false;

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onKeyDown(TextView textView, Spannable spannable, int i, KeyEvent keyEvent) {
        switch (i) {
            case 23:
            case 66:
                if (keyEvent.getRepeatCount() == 0 && a(1, textView, spannable)) {
                    return true;
                }
                break;
        }
        return super.onKeyDown(textView, spannable, i, keyEvent);
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    protected boolean up(TextView textView, Spannable spannable) {
        if (a(2, textView, spannable)) {
            return true;
        }
        return super.up(textView, spannable);
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    protected boolean down(TextView textView, Spannable spannable) {
        if (a(3, textView, spannable)) {
            return true;
        }
        return super.down(textView, spannable);
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    protected boolean left(TextView textView, Spannable spannable) {
        if (a(2, textView, spannable)) {
            return true;
        }
        return super.left(textView, spannable);
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    protected boolean right(TextView textView, Spannable spannable) {
        if (a(3, textView, spannable)) {
            return true;
        }
        return super.right(textView, spannable);
    }

    private boolean a(int i, TextView textView, Spannable spannable) {
        int i2;
        int i3;
        Layout layout = textView.getLayout();
        int totalPaddingTop = textView.getTotalPaddingTop() + textView.getTotalPaddingBottom();
        int scrollY = textView.getScrollY();
        int lineForVertical = layout.getLineForVertical(scrollY);
        int lineForVertical2 = layout.getLineForVertical((textView.getHeight() + scrollY) - totalPaddingTop);
        int lineStart = layout.getLineStart(lineForVertical);
        int lineEnd = layout.getLineEnd(lineForVertical2);
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(lineStart, lineEnd, ClickableSpan.class);
        int selectionStart = Selection.getSelectionStart(spannable);
        int selectionEnd = Selection.getSelectionEnd(spannable);
        int min = Math.min(selectionStart, selectionEnd);
        int max = Math.max(selectionStart, selectionEnd);
        if (min < 0 && spannable.getSpanStart(pas) >= 0) {
            max = spannable.length();
            min = max;
        }
        if (min > lineEnd) {
            max = Integer.MAX_VALUE;
            min = Integer.MAX_VALUE;
        }
        if (max < lineStart) {
            i2 = -1;
            i3 = -1;
        } else {
            i2 = max;
            i3 = min;
        }
        switch (i) {
            case 1:
                if (i3 != i2) {
                    ClickableSpan[] clickableSpanArr2 = (ClickableSpan[]) spannable.getSpans(i3, i2, ClickableSpan.class);
                    if (clickableSpanArr2.length == 1) {
                        clickableSpanArr2[0].onClick(textView);
                        return false;
                    }
                    return false;
                }
                return false;
            case 2:
                int i4 = -1;
                int i5 = -1;
                for (int i6 = 0; i6 < clickableSpanArr.length; i6++) {
                    int spanEnd = spannable.getSpanEnd(clickableSpanArr[i6]);
                    if ((spanEnd < i2 || i3 == i2) && spanEnd > i4) {
                        i5 = spannable.getSpanStart(clickableSpanArr[i6]);
                        i4 = spanEnd;
                    }
                }
                if (i5 >= 0) {
                    Selection.setSelection(spannable, i4, i5);
                    return true;
                }
                return false;
            case 3:
                int i7 = Integer.MAX_VALUE;
                int i8 = Integer.MAX_VALUE;
                for (int i9 = 0; i9 < clickableSpanArr.length; i9++) {
                    int spanStart = spannable.getSpanStart(clickableSpanArr[i9]);
                    if ((spanStart > i3 || i3 == i2) && spanStart < i8) {
                        i7 = spannable.getSpanEnd(clickableSpanArr[i9]);
                        i8 = spanStart;
                    }
                }
                if (i7 < Integer.MAX_VALUE) {
                    Selection.setSelection(spannable, i8, i7);
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onKeyUp(TextView textView, Spannable spannable, int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.paq = false;
        }
        if (action == 1 || action == 0) {
            int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
            int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int scrollX = x + textView.getScrollX();
            int scrollY = y + textView.getScrollY();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (clickableSpanArr.length != 0) {
                if (action == 1) {
                    if (!this.paq) {
                        clickableSpanArr[0].onClick(textView);
                    }
                } else if (action == 0) {
                }
                return true;
            }
            Selection.removeSelection(spannable);
            spannable.removeSpan(spannable);
            return false;
        }
        return false;
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public void initialize(TextView textView, Spannable spannable) {
        Selection.removeSelection(spannable);
        spannable.removeSpan(pas);
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public void onTakeFocus(TextView textView, Spannable spannable, int i) {
        Selection.removeSelection(spannable);
        if ((i & 1) != 0) {
            spannable.setSpan(pas, 0, 0, 34);
        } else {
            spannable.removeSpan(pas);
        }
    }

    public static b eqP() {
        if (par == null) {
            par = new b();
        }
        return par;
    }
}
