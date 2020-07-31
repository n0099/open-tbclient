package tv.chushou.widget.ninepatch;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
/* loaded from: classes6.dex */
public final class Div implements Externalizable {
    public int start;
    public int stop;

    public Div() {
    }

    public Div(int i, int i2) {
        this.start = i;
        this.stop = i2;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.start = objectInput.readByte();
        this.stop = objectInput.readByte();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(this.start);
        objectOutput.writeByte(this.stop);
    }
}
