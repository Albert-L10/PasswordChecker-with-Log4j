class PasswordException extends Exception{

    public PasswordException(String message)
    {
        super ("User password is not ok: "+message);
    }
}
