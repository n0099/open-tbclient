package javassist.compiler.ast;

import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
/* loaded from: classes.dex */
public class IntConst extends ASTree {
    protected int type;
    protected long value;

    public IntConst(long j, int i) {
        this.value = j;
        this.type = i;
    }

    public long get() {
        return this.value;
    }

    public void set(long j) {
        this.value = j;
    }

    public int getType() {
        return this.type;
    }

    @Override // javassist.compiler.ast.ASTree
    public String toString() {
        return Long.toString(this.value);
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

    private IntConst a(int i, IntConst intConst) {
        long j;
        int i2 = BdWebErrorView.ERROR_CODE_401;
        int i3 = this.type;
        int i4 = intConst.type;
        if (i3 == 403 || i4 == 403) {
            i2 = 403;
        } else if (i3 != 401 || i4 != 401) {
            i2 = 402;
        }
        long j2 = this.value;
        long j3 = intConst.value;
        switch (i) {
            case 37:
                i3 = i2;
                j = j2 % j3;
                break;
            case 38:
                i3 = i2;
                j = j2 & j3;
                break;
            case 42:
                i3 = i2;
                j = j2 * j3;
                break;
            case 43:
                i3 = i2;
                j = j2 + j3;
                break;
            case 45:
                i3 = i2;
                j = j2 - j3;
                break;
            case 47:
                i3 = i2;
                j = j2 / j3;
                break;
            case 94:
                i3 = i2;
                j = j2 ^ j3;
                break;
            case SocialAPIErrorCodes.ERROR_UPLOAD_FILE_SIZE_TOO_LARGE /* 124 */:
                i3 = i2;
                j = j2 | j3;
                break;
            case 364:
                j = this.value << ((int) j3);
                break;
            case 366:
                j = this.value >> ((int) j3);
                break;
            case 370:
                j = this.value >>> ((int) j3);
                break;
            default:
                return null;
        }
        return new IntConst(j, i3);
    }

    private DoubleConst a(int i, DoubleConst doubleConst) {
        double d;
        double d2 = this.value;
        double d3 = doubleConst.value;
        switch (i) {
            case 37:
                d = d2 % d3;
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
                d = d2 * d3;
                break;
            case 43:
                d = d2 + d3;
                break;
            case 45:
                d = d2 - d3;
                break;
            case 47:
                d = d2 / d3;
                break;
        }
        return new DoubleConst(d, doubleConst.type);
    }
}
