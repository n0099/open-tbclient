package tv.athena.revenue.payui.view.dialog;
/* loaded from: classes7.dex */
public interface DialogListener {

    /* loaded from: classes7.dex */
    public enum ClickArea {
        BUTTOM_AREA(1),
        EMPTY_AREA(2),
        ON_DIALOG_DISMISS(3),
        ON_DIALOG_CANCEL(4);

        ClickArea(int i2) {
        }
    }

    void a(ClickArea clickArea);
}
