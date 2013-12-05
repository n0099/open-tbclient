package javassist.tools.rmi;

import java.applet.Applet;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.URL;
/* loaded from: classes.dex */
public class ObjectImporter implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private static final Class[] f3030a = {ObjectImporter.class, Integer.TYPE};
    private int orgPort;
    private String orgServername;
    private int port;
    private String servername;
    private final byte[] endofline = {13, 10};
    protected byte[] lookupCommand = "POST /lookup HTTP/1.0".getBytes();
    protected byte[] rmiCommand = "POST /rmi HTTP/1.0".getBytes();

    public ObjectImporter(Applet applet) {
        URL codeBase = applet.getCodeBase();
        String host = codeBase.getHost();
        this.servername = host;
        this.orgServername = host;
        int port = codeBase.getPort();
        this.port = port;
        this.orgPort = port;
    }

    public ObjectImporter(String str, int i) {
        this.servername = str;
        this.orgServername = str;
        this.port = i;
        this.orgPort = i;
    }

    public Object getObject(String str) {
        try {
            return lookupObject(str);
        } catch (ObjectNotFoundException e) {
            return null;
        }
    }

    public void setHttpProxy(String str, int i) {
        String str2 = "POST http://" + this.orgServername + ":" + this.orgPort;
        this.lookupCommand = (str2 + "/lookup HTTP/1.0").getBytes();
        this.rmiCommand = (str2 + "/rmi HTTP/1.0").getBytes();
        this.servername = str;
        this.port = i;
    }

    public Object lookupObject(String str) {
        try {
            Socket socket = new Socket(this.servername, this.port);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(this.lookupCommand);
            outputStream.write(this.endofline);
            outputStream.write(this.endofline);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeUTF(str);
            objectOutputStream.flush();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
            a(bufferedInputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
            int readInt = objectInputStream.readInt();
            String readUTF = objectInputStream.readUTF();
            objectInputStream.close();
            objectOutputStream.close();
            socket.close();
            if (readInt >= 0) {
                return a(readInt, readUTF);
            }
            throw new ObjectNotFoundException(str);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ObjectNotFoundException(str, e);
        }
    }

    private Object a(int i, String str) {
        return Class.forName(str).getConstructor(f3030a).newInstance(this, new Integer(i));
    }

    public Object call(int i, int i2, Object[] objArr) {
        String readUTF;
        Object obj = null;
        try {
            Socket socket = new Socket(this.servername, this.port);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
            bufferedOutputStream.write(this.rmiCommand);
            bufferedOutputStream.write(this.endofline);
            bufferedOutputStream.write(this.endofline);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
            objectOutputStream.writeInt(i);
            objectOutputStream.writeInt(i2);
            a(objectOutputStream, objArr);
            objectOutputStream.flush();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
            a(bufferedInputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
            boolean readBoolean = objectInputStream.readBoolean();
            if (readBoolean) {
                obj = objectInputStream.readObject();
                readUTF = null;
            } else {
                readUTF = objectInputStream.readUTF();
            }
            objectInputStream.close();
            objectOutputStream.close();
            socket.close();
            if (obj instanceof RemoteRef) {
                RemoteRef remoteRef = (RemoteRef) obj;
                obj = a(remoteRef.oid, remoteRef.classname);
            }
            if (readBoolean) {
                return obj;
            }
            throw new RemoteException(readUTF);
        } catch (IOException e) {
            throw new RemoteException(e);
        } catch (ClassNotFoundException e2) {
            throw new RemoteException(e2);
        } catch (Exception e3) {
            throw new RemoteException(e3);
        }
    }

    private void a(InputStream inputStream) {
        int i;
        do {
            i = 0;
            while (true) {
                int read = inputStream.read();
                if (read < 0 || read == 13) {
                    break;
                }
                i++;
            }
            inputStream.read();
        } while (i > 0);
    }

    private void a(ObjectOutputStream objectOutputStream, Object[] objArr) {
        int length = objArr.length;
        objectOutputStream.writeInt(length);
        for (int i = 0; i < length; i++) {
            if (objArr[i] instanceof a) {
                objectOutputStream.writeObject(new RemoteRef(((a) objArr[i]).a()));
            } else {
                objectOutputStream.writeObject(objArr[i]);
            }
        }
    }
}
