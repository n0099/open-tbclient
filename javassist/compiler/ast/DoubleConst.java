package javassist.compiler.ast;

import com.baidu.browser.explorer.BdWebErrorView;
/* loaded from: classes.dex */
public class DoubleConst extends ASTree {
    protected int type;
    protected double value;

    public DoubleConst(double d, int i) {
        this.value = d;
        this.type = i;
    }

    public double get() {
        return this.value;
    }

    public void set(double d) {
        this.value = d;
    }

    public int getType() {
        return this.type;
    }

    @Override // javassist.compiler.ast.ASTree
    public String toString() {
        return Double.toString(this.value);
    }

    @Override // javassist.compiler.ast.ASTree
    public void accept(a aVar) {
        aVar.a(this);
    }

    public ASTree compute(int i, ASTree aSTree) {
        if (aSTree instanceof IntConst) {
            return a(i, (IntConst) aSTree);
        }
        if (aSTree instanceof DoubleConst) {
            return a(i, (DoubleConst) aSTree);
        }
        return null;
    }

    private DoubleConst a(int i, DoubleConst doubleConst) {
        int i2 = BdWebErrorView.ERROR_CODE_405;
        if (this.type != 405 && doubleConst.type != 405) {
            i2 = BdWebErrorView.ERROR_CODE_404;
        }
        return a(i, this.value, doubleConst.value, i2);
    }

    private DoubleConst a(int i, IntConst intConst) {
        return a(i, this.value, intConst.value, this.type);
    }

    private static DoubleConst a(int i, double d, double d2, int i2) {
        double d3;
        switch (i) {
            case 37:
                d3 = d % d2;
                break;
            case 38:
            case 39:
            case 40:
            case 41:
            case 44:
            case 46:
            default:
                return null;
            case 42:
                d3 = d * d2;
                break;
            case 43:
                d3 = d + d2;
                break;
            case 45:
                d3 = d - d2;
                break;
            case 47:
                d3 = d / d2;
                break;
        }
        return new DoubleConst(d3, i2);
    }
}
